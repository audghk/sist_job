package day0208;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class myServer {

	public void msgServer() throws IOException {
		//1. 서버소켓 생성
		ServerSocket server=null;
		Socket client=null;
		DataOutputStream dos=null;
		DataInputStream dis=null;
		
		try {
			server=new ServerSocket(1570);
			String msg="안녕하세요? 이게 뭔가요..? 새해 복 많이 받으세요^o^";
//			while(true) {
				//3. 접속자 소켓을 받는다.
				client=server.accept();
				//4. 메시지를 보내기 위한 스트림을 소켓에서 얻는다.
				dos=new DataOutputStream(client.getOutputStream());
				dis=new DataInputStream(client.getInputStream());
				//5. 스트림에 메시지 쓰기
				dos.writeUTF(msg);
				String msg2=dis.readUTF();
				//6. 목적지(socket)로 스트림의 내용을 분출
				JOptionPane.showMessageDialog(null,msg2);
//			}
		}finally {
			//7. 연결 끊기
			if(dos!=null) {dos.close();}
			if(client!=null) {client.close();}
			if(server!=null) {server.close();}
		}
		
		
	}
	public static void main(String[] args) {
		myServer ms=new myServer();
		try {
			ms.msgServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
