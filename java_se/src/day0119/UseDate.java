package day0119;

import java.util.Date;

/**
 * 날짜 관련 클래스 :
 * 자바에서 유일하게 날짜 정보를 얻을 수 있는 클래스는 System클래스이고
 *  currntTimeMillis()를 사용하여 1970.01.01-00:00:00 초부터 현재까지 시간을
 *  ms로 반환한다.
 */
public class UseDate {

	public UseDate() {
		//1. 생성
		Date d=new Date();//
		System.out.println(d);//Date가 toString을 override했기때문에 주소가 아니라 문자가 나온다.
		//2. method는 비추천 많아 생략
			
	}
	
	public static void main(String[] args) {

		new UseDate();
//		long l=System.currentTimeMillis();
//		System.out.println(l);
//		Date d=new Date(l);
//		System.out.println(d);

		
		
		
	}

}
