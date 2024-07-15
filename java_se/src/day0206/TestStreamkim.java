package day0206;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

/**
C:/dev/temp/java_write4.txt 파일을 생성한 후 
C:/dev/temp/java_read.txt를 읽어들여 C:/dev/temp/java_write4.txt에 쓰는 코드 작성

단, C:/dev/temp/java_write4.txt 파일이 존재하지 않으면 파일을 생성하고,
존재한다면, 덮어쓸 것인지 물어본 후 파일에 덮어쓴다 
 * 
 */
public class TestStreamkim {
	
	public TestStreamkim() throws IOException {
		File newFile = new File("C:/dev/temp/java_write4.txt");
		if(newFile.exists()) {
			switch(JOptionPane.showConfirmDialog(null, newFile.getAbsolutePath() + "이 존재합니다.\n덮어쓰시겠습니까?")) {
			case JOptionPane.NO_OPTION:
			case JOptionPane.CANCEL_OPTION:
				return;
			} // end switch
		} // end if
		
//		StringBuilder sb = new StringBuilder(); 
//		File prevFile = new File("C:/dev/temp/java_read.txt");
//		try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(prevFile)))) {
//			String str = "";
//			while( (str = bf.readLine()) != null) {
//				sb.append(str).append("\n");
//			} // end while
//		} catch (IOException ie) {
//			ie.printStackTrace();
//		} // end catch
//		
//		try(BufferedWriter bw = new BufferedWriter(new FileWriter(newFile))) {
//			bw.write(sb.toString());
//		} catch (IOException ie) {
//			ie.printStackTrace();
//		} // end catch
		
		//읽기와 쓰기같이 묶어서~
		BufferedReader br=null;
		BufferedWriter bw=null;
		try {
			File readFile=new File("c:/dev/temp/java_read.txt");
			br=new BufferedReader(new FileReader(readFile));
			bw=new BufferedWriter(new FileWriter(newFile));
			
			String lineData="";
			while((lineData=br.readLine())!=null) {
				bw.write(lineData+"\n");
			}
		}finally {
			if(br!=null) {
				br.close();
			}
			if(bw!=null) {
				br.close();
			}
		}
		
		
	} // TestStream
	
	public static void main(String[] args) {
		try {
			new TestStreamkim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // main

} // class
