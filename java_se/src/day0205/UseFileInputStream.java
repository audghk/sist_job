package day0205;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UseFileInputStream {
	
	public UseFileInputStream() throws IOException {
		//1. File 생성
		File file=new File("c:/dev/temp/java_read.txt");
		if(!file.exists()) {
			JOptionPane.showMessageDialog(null, "파일명이나 경로를 확인해주세요.");
			return;
		}
		//2. File을 읽기 위한 Stream을 연결
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(file);
			//3. 반복문을 돌려서 값을 얻어 사용.
			int readData=0;
			while((readData=fis.read())!=-1) {//1byte 읽어들여 값이 존재하면
				System.out.print((char)readData);//값을 출력한다.
			}//end while
		}finally {
			if(fis!=null) {
				fis.close();
			}
		}//end finally
		
	}//UseFileInputStream

	public static void main(String[] args) {

//		try {
//			new UseFileInputStream();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	
		JTextArea jta=new JTextArea(10,50);
		JScrollPane jsp=new JScrollPane(jta);
		jta.append("이름 수정한 날짜 유형 크기\n");
		jta.append("eclipse yyyy-MM-dd HH:mm 폴더\n");
		jta.append("env.bat yyyy-MM-dd HH:mm 파일 4byte\n");
		jta.setEditable(false);
		JOptionPane.showMessageDialog(null, jsp);
		
	}

}
