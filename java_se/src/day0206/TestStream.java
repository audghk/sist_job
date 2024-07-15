package day0206;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class TestStream {

	public TestStream() throws IOException {

		// c:/dev/temp/java_write4.txt 파일을 생성 한 후
		// c:/dev/temp/java_read.txt 읽어들여 java_write4.txt 쓰는
		// 코드를 작성해보세요.

		// 단, c:/dev/temp/java_write4.txt파일이 존재하지 않으면 파일을 생성하고,
		// 존재한다면 덮어쓸 것인지 물어본 후 파일에 덮어쓴다.

		File file = new File("C:/dev/temp/java_write4.txt");
		File file2 = new File("c:/dev/temp/java_read.txt");

		FileWriter fw = null;
		if (file.exists()) {
			JOptionPane.showMessageDialog(null, file.getName()+" 파일이 이미 존재합니다.");
			return;
		}
		try {
			fw = new FileWriter(file);
		} finally {
			if (fw != null) {
				fw.close();
			}
		}
		FileOutputStream fos=null;
		BufferedReader br=null;
		try {
			fos=new FileOutputStream(file2);
			br=new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
			String str="";
			while((str=br.readLine())!=null) {
				System.out.println(str);
			}
			byte[] b=str.getBytes();
			System.out.println(Arrays.toString(b));
			
			fos.write(b);
			fos.flush();
			
		}finally {
//			if(fos!=null) {
//				fos.close();
//			}
//			if(br!=null) {
//				fos.close();
//			}
		}
	
		
	}//TestStream

	public static void main(String[] args) {
		try {
			new TestStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
