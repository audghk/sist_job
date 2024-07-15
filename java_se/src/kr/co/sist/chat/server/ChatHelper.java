package kr.co.sist.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.invoke.StringConcatFactory;
import java.net.Socket;
import java.security.PublicKey;

import javax.swing.DefaultListModel;

/**
 * 1. 서버에서 소켓을 전달받아 2. 대화를 읽고, 쓰기 위한 스트림을 연결하고 3. 대화를 무한루프로 읽어들여 4. 모든 접속자에게
 * 출력하는 일
 */
public class ChatHelper extends Thread {
	private Socket someClient;
	private DataInputStream disReadStream;
	private DataOutputStream dosWriteStream;
	private int cnt;
	private DefaultListModel<String> dlmConnect;
	private String connIp;
	private String nick;

	public ChatHelper(Socket someClient, int cnt, DefaultListModel<String> dlmConnect) throws IOException {
		this.someClient = someClient;
		this.cnt = cnt;
		this.dlmConnect = dlmConnect;
		connIp = someClient.getInetAddress().toString();// 접속자 ip를 저장
		// 소켓에서 읽기 스트림 연결
		disReadStream = new DataInputStream(someClient.getInputStream());
		// 소켓에서 쓰기 스트림 연결
		dosWriteStream = new DataOutputStream(someClient.getOutputStream());

		nick = disReadStream.readUTF();

		// 서버창에 접속자 현황을 보여준다.
		dlmConnect.addElement(nick + "님께서 " + cnt + "번째로 접속하였습니다. [" + someClient.getInetAddress() + "]");
		//
		broadcast(nick + "님께서 접속했습니다.");
	}

	@Override
	public void run() {
		// 대화를 읽어들여 모든 접속자에게 출력하는 일
		String revMsg;
		try {
			while (true) {
				revMsg = disReadStream.readUTF();
				broadcast(revMsg);

			} // end while
		} catch (IOException e) {// 메시지를 읽다가 못 읽는 상태 => 접속자가 종료 했음.
			dlmConnect.addElement(cnt + "번째 접속자가 접속을 종료하였습니다." + connIp);// 서버 관리 창에 설정
		}
		try {
			if (someClient != null) {
				someClient.close();
			}
			// 나를 제외한
			MultiChatServer.listConnect.remove(this);
			// 모든 접속자에게 메시지 보내기
			broadcast(nick + "님이 접속을 종료하였습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// run

	public String getNick() {
		return nick;
	}
	
	/**
	 * 모든 접속자에게 메시지를 보내는 method
	 * 
	 * @param msg
	 * @throws IOException
	 */
	public void broadcast(String msg) throws IOException {
		for (ChatHelper ch : MultiChatServer.listConnect) {
			ch.dosWriteStream.writeUTF(msg);
			ch.dosWriteStream.flush();
		}
	}

}
