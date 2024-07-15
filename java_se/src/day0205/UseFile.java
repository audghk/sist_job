package day0205;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File 클래스를 사용한
 */
public class UseFile {

	public static void main(String[] args) {
		
		//1. 생성
		File file=new File("c:/dev/temp/java_read.txt");
		System.out.println(file);
		
		if(!file.exists()) {
			System.out.println("파일이 ㅇㅅㅇ");
			return;//early return                                                   흠..... =>
		}
		System.out.println(file.isFile()?"파일" : "디렉토리");
		System.out.println(file.isDirectory()?"디렉토리" : "파일");
		System.out.println(file.canRead()?"읽을수있음" : "읽을수없음");
		System.out.println(file.canWrite()?"쓸수있음" : "쓸수없음");
		System.out.println(file.canExecute()?"실행가능" : "실행불가능");
		System.out.println(file.isHidden()?"숨김파일" : "일반파일");
		System.out.println("파일의 크기 "+file.length()+"byte");
		System.out.println("절대경로 "+file.getAbsolutePath());//대문자로 바꿔도 됨
		try {
			System.out.println("규범경로 "+file.getCanonicalPath());//대문자로 넣어도 경로는 안바뀜		
		}catch(IOException ie){
			ie.printStackTrace();
		}
		long lastModified=file.lastModified();
		System.out.println("경로 "+file.getParent());
		System.out.println("파일명 "+file.getName());
		System.out.println("파일이 마지막으로 수정된 날짜 : "+lastModified);
		
		System.out.println("파일이 마지막으로 수정된 날짜 : "+new Date(lastModified));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date(lastModified)));//날짜와 시간을 알아보기 쉽게 출력
				
		

	}

}
