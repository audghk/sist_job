package day0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 키보드의 입력값 받기
 */
public class UseKeyboardInput {	
	
	public UseKeyboardInput() throws IOException{
		
		System.out.println("아무키나 누르고 엔터");
//		int readData=System.in.read();
//		System.out.println("입력 값 : "+readData);
		
//		int readData=0;
//		while((readData=System.in.read())!=13) {
//			System.out.println("입력 값 : "+readData);			
//		}
		
		//입력한 모든 문자열이 그대로 출력되는 코드를 작성해보세요.(한글을 출력할 수 없다.)
//		int readData=0;
//		while((readData=System.in.read())!=13) {//in => 8bit Stream 한글은 한자에 2byte
//			System.out.print((char)readData);			
//		}
		
		//한글을 줄단위로 읽어서 보여줄 수 있는 16비트 stream의 사용.
		BufferedReader br=null;
		try {
			br=new BufferedReader(new InputStreamReader(System.in));
			String readData=br.readLine();
			System.out.println("입력 값 : "+readData);	

		}finally {
			if(br!=null) {
				br.close();//연결이 끊어지지 않으면 메모리 누수가 발생한다..			
			}
		}
		
	}
	
	public static void main(String[] args) { //이게 뭔가요..?

		try {
			new UseKeyboardInput();
		}catch(IOException e) {//UseKeyboardInput() 생성자 안에서 발생하는 여러개의 예외를 묶어서 처리할 수 있다.
			e.printStackTrace();
		}
		
	}

}
