package day0207;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class UseFiles {

	public void allLines() {
		//1. 읽어 들일 파일의 경로 설정
		Path path=Paths.get("c:/dev/temp/java_read.txt");
		System.out.println(path);
		//2. 파일의 내용을 읽기
		try {
			List<String> lines=Files.readAllLines(path);
//			for(String readLine : lines) {//여러번 쓸 때
//				System.out.println(readLine);
//			}
			Iterator<String> ita=lines.iterator();
			while(ita.hasNext()) {//한번만 쓸 때
				System.out.println(ita.next());
			}
			
		} catch (NoSuchFileException e) {
			System.err.println("경로를 확인하세요.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		UseFiles uf=new UseFiles();
		uf.allLines();
		
	}

}
