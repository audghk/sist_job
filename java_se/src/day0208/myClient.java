package day0208;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class myClient {

	public void msgClient() throws IOException {
		DataInputStream dis=null;
		Socket client=null;
		DataOutputStream dos=null;
		
		try {

			String msg2="미연언니 최고";
			//2. 소켓 생성 => 서버에 연결(3 way handshaking)하여 회선 확립 시도
			client=new Socket("192.168.10.216",1570);
			//4. 스트림 열기
			dis=new DataInputStream(client.getInputStream());
			dos=new DataOutputStream(client.getOutputStream());
			//7. 값 얻기
			String msg=dis.readUTF();
			dos.writeUTF(msg2);
			JOptionPane.showMessageDialog(null,msg);
			
		}finally {
			//8. 연결 끊기
			if(dos!=null) {dos.close();}
			if(dis!=null) {dis.close();}
			if(client!=null) {client.close();}
		}
		
	}//msgClient
	
	public static void main(String[] args) {
		myClient mc=new myClient();
		try {
			mc.msgClient();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
