package kr.co.sist.chat.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MultiChatClient extends JFrame implements ActionListener,Runnable {

	private JTextField jtfServerIp,jtfNick, jtfTalk;
	private JTextArea jtaTalkDisplay;
	private JScrollPane jspJtaTalk;
	private JButton jbtnConnectServer, jbtnCapture;
	
	private Socket someClient;
	private DataInputStream disReadStream;
	private DataOutputStream dosWriteStream;
	
	private Thread threadRead;
	
	public MultiChatClient() {
		super("채팅 클라이이언트");
		
		jtfServerIp=new JTextField("192.168.10.231",10);
		jtfNick=new JTextField(7);
		jtfTalk=new JTextField();
		jtaTalkDisplay=new JTextArea();
		jtaTalkDisplay.setEditable(false);
		jspJtaTalk=new JScrollPane( jtaTalkDisplay );
		jbtnConnectServer=new JButton("서버접속"); 
		jbtnCapture=new JButton("대화저장");
		
		JPanel jpNorth=new JPanel();
		
		jpNorth.add(new JLabel("서버주소"));
		jpNorth.add(jtfServerIp);
		jpNorth.add(new JLabel("대화명"));
		jpNorth.add(jtfNick);
		jpNorth.add(jbtnConnectServer);
		jpNorth.add(jbtnCapture);
		
		add("North", jpNorth);
		add("Center", jspJtaTalk);
		add("South", jtfTalk);

		jbtnConnectServer.addActionListener(this);
		jbtnCapture.addActionListener(this);
		jtfTalk.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				try {
					closeWin();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				System.exit(JFrame.ABORT);
			}
		});
		
		setBounds(100,100,700,400);
		setVisible(true);	
		
	}
	
	public void closeWin() throws IOException {
		try {
			if(someClient!=null) {someClient.close();}
		}finally {
			dispose();
		}
	}

	@Override
	public void run() {
		//메시지를 무한 루프로 읽어들여 J.T.A에 추가
		try {
			while(true) {
				//읽어들인 데이터를 J.T.A에 추가
				jtaTalkDisplay.append(disReadStream.readUTF()+"\n");
				//스크롤바를 가장 아래로 내린다.
				//수직 스크롤바의 최고값을 얻어서, 다시 수직스크롤 바에 설정하면 가장 아래로 내려간다.
				jspJtaTalk.getVerticalScrollBar().setValue(jspJtaTalk.getVerticalScrollBar().getMaximum());
			}
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(this,"서버가 종료되었습니다.");
			ie.printStackTrace();
		}
	}

	private void connectToServer() throws UnknownHostException, IOException {
		
		String ip=jtfServerIp.getText().trim();
		String nick=jtfNick.getText().trim();
	
		if(nick.isEmpty()) {
			JOptionPane.showMessageDialog(this,"대화명은 필수 입력입니다.");
			jtfNick.setText("");
			jtfNick.requestFocus();
			return;
		}
		
		if(someClient !=null) {
			JOptionPane.showMessageDialog(this,"서버에 접속 중 입니다.");
			return;
		}
		
		someClient=new Socket(ip,2024);
		//메시지를 읽기 위한 스트림
		disReadStream=new DataInputStream(someClient.getInputStream());
		//메시지를 쓰기 위한 스트림		
		dosWriteStream=new DataOutputStream(someClient.getOutputStream());
		
		dosWriteStream.writeUTF(nick);//닉네임을 서버로 보낸다.
		dosWriteStream.flush();
		
		//데이터를 읽기위한 Thread를 실행
		threadRead=new Thread(this);
		threadRead.start();//호출
	}
	
	/**
	 * 서버로 메시지를 보내기 위한 method
	 * @throws IOException 
	 */
	public void sendMsg() throws IOException {
		if(dosWriteStream!=null) {//서버에 연결된 경우에만 메시지 전송
			String nick=jtfNick.getText().trim();
			String talk=jtfTalk.getText();//공개 허용
			//입력된 대화를 스트림에 쓰고
			dosWriteStream.writeUTF("["+nick+"]"+talk);
			//목적지로 분출
			dosWriteStream.flush();
			//대화 내용의 초기화
			jtfTalk.setText("");
		}
	}
	
	public void capture() throws IOException {
		File saveDir=new File("c:/dev/chat_backup/");
		if(saveDir.exists()) {
			saveDir.mkdirs();			
		}
		File saveFile=new File(saveDir.getAbsolutePath()+"capture_"+System.currentTimeMillis()+".dat");
		System.out.println(saveFile);
//		FileOutputStream fileOutputStream=null;
		
		FileWriter fw=null;
		
		try {
			fw=new FileWriter(saveFile);
			fw.write(jtaTalkDisplay.getText());
			fw.flush();
		}finally {
			if(fw!=null) {fw.close();}
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource()==jbtnConnectServer) {//서버 연결
			try {
				connectToServer();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "서버가 종료되었습니다.");
				e.printStackTrace();
			}
		}
		if(ae.getSource()==jtfTalk) {//대화 입력
			try {
				sendMsg();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(ae.getSource()==jbtnCapture) {//대화내용 캡처 > 갈무리
			try {
				capture();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	
}
