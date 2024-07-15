package day0206;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * 16bit stream을 사용한 텍스트 파일의 내용읽기
 */
public class UseFileReader {

	public UseFileReader() throws IOException {
		// 1. File생성
		File readFile = new File("C:/dev/temp/java_read.txt");
		if (!readFile.exists()) {
			System.out.println(readFile.getAbsolutePath() + "는 존재하지 않습니다.");
			return;
		}
		// 2. 스트림 생성
//		FileInputStream fr = new FileInputStream(readFile);// 파일과 연결
//		BufferedReader br = new BufferedReader(fr);// 연결된 파일에서 줄단위로 읽어들이는 일
		BufferedReader br=null;
		try {
			//3. 스트림에 연결되어 있는 파일을 읽어들인다.
			String str="";
			while((str=br.readLine())!=null) {
				System.out.println(str);
			}
		}finally {
			if(br!=null) {
				br.close();
			}
		}
		
		
	}//UseFileReader

	public static void main(String[] args) {

		try {
			new UseFileReader();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
