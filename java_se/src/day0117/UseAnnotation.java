package day0117;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 */
public class UseAnnotation {

	@Deprecated //'비추천 method입니다~' 표시. 정상동작 함
	public void test() {
		System.out.println("오늘은 수요일 입니다.");
		Date date=new Date();
		System.out.println(date.getYear()+1900);//일은 하는데 잘못할 가능성이 있다~ 표시
	}
	
	@SuppressWarnings({"unused","rawtypes"})//'변수를 사용안할수도 있다~' , 배열로 처리하면 여러개 쓸수있음
//	@SuppressWarnings("rawtypes")// error 발생
	public void test2() {
//		@SuppressWarnings("unused")//'변수를 사용안할수도 있다~'
		int day;
		int k;
		
//		@SuppressWarnings("rawtypes")
		List list=new ArrayList();
		
	}
	
	//Override는 부모클래스가 가지고 있는 method를 자식 클래스에서 그대로 정의하는 것.
	@Override
	public String toString() {
		return "생성된 객체의 주소가 아닌 메시지";
	}
	
	public static void main(String[] args) {

		UseAnnotation ua=new UseAnnotation();//객체(instance - ua)는 heap의 주소를 가진다
		ua.test();
		
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		
		System.out.println(ua);//내 객체 : 주소 heap의 주소 출력. > toString을 Override하면 내가 원하는 메시지가 출력
		System.out.println(d);//자바제공 객체 : 메시지
		System.out.println(sdf);//자바제공 객체 : 주소
		
		int i=10;
		System.out.println(i);
		long l=20;
		System.out.println(l);
		
	}

}
