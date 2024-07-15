package day0213;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SimpleChatClient extends JFrame implements ActionListener, Runnable {
	private JTextArea jtaTalkDisplay;
	private JTextField jtfTalk;
	private JScrollPane jspTalk;
	
	private Socket someClient;
	private DataInputStream disReadStream;
	private DataOutputStream dosWriteStream;
	
	
	public SimpleChatClient() {
		super(":::::::채팅클라이언트:::::::");
		jtaTalkDisplay=new JTextArea();
		jtaTalkDisplay.setEditable(false);
		jtfTalk=new JTextField();
		jspTalk=new JScrollPane( jtaTalkDisplay);
		
		jspTalk.setBorder(new TitledBorder("대화내용"));
		jtfTalk.setBorder(new TitledBorder("대화"));
		
		add("Center", jspTalk);
		add("South", jtfTalk);
		
		
		setBounds(100, 100, 500, 600);
		setVisible(true);
		
		try {
			connectToServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		jtfTalk.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent we) {
				try {
					closeClient();
				} catch (IOException ie) {
					ie.printStackTrace();
				}finally {
					dispose();
				}
			}
		});
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//SimpleChatServer
	
	private void closeClient() throws IOException {
		if(dosWriteStream!=null) {dosWriteStream.close();}
		if(disReadStream!=null) {disReadStream.close();}
		if(someClient!=null) {someClient.close();}
	}
	
	private void connectToServer() throws UnknownHostException, IOException {
		//2. 소켓 생성 // 서버로 연결을 시도
		someClient=new Socket("192.168.10.210",2024);//loop back
		
		//4. 데이터를 주고, 받을 수 있도록 스트림을 연결
		disReadStream=new DataInputStream(someClient.getInputStream());
		dosWriteStream=new DataOutputStream(someClient.getOutputStream());
		//Thread로 동작해야할 코드를 가진 클래스와 Thread 클래스를 has a 관계로 생성
		Thread t=new Thread(this);
		//start() 호출 -> run()
		t.start();
	}
	
	/**
	 * 접속자가 보내오는 메시지를 계속 읽어들인다.
	 * @throws IOException 
	 */
	@Override
	public void run() {
		if(disReadStream !=null) {
			String msg="";
			try {
				while(true) {
					//메시지를 읽어들여 J.T.A에 출력
					msg=disReadStream.readUTF();
					jtaTalkDisplay.append(msg+"\n");
				}
			}catch(IOException ie) {
				JOptionPane.showMessageDialog(this, "접속자가 연결을 종료하였습니다.");
				ie.printStackTrace();
			}
		}
	}
	
	private void sendMsg() throws IOException {
		if(dosWriteStream==null) {
			JOptionPane.showMessageDialog(this, "서버에 연결 전입니다.");
			return;
		}
		
		String msg=jtfTalk.getText();
		
		if(!msg.isEmpty()) {
			//메시지를 스트림에 쓰기
			dosWriteStream.writeUTF("명화 : "+msg);
			//스트림의 내용을 목적지로 분출
			dosWriteStream.flush();
			//J.T.F 초기화
			jtfTalk.setText("");
		}
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		try {
			sendMsg();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}//actionPerformed

	public static void main(String[] args) {
		new SimpleChatClient();
//		SimpleChatClient scc=new SimpleChatClient();
//		try {
//			scc.connectToServer();
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}//main

}//class
