package day0111;

/**
 * 문자열의 사용.
 * 문자열 저장소에 저장된 시작주소를 저장하고 사용하기 위한 데이터형으로 java.lang.String
 * 클래스(참조형 데이터 형 - new 해서 사용)를 제공한다.
 */
public class UseString {

	public static void main(String[] args) {

		//기본형 형식의 사용. (new를 사용하지 않고 사용)
		String str="ABCDE";
		
		//참조형 형식의 사용. (new 사용)
		String str1=new String("ABCDE");
		
		System.out.println("기본형 형식 : " + str);
		System.out.println("참조형 형식 : " + str1);
		
		//== 비교 : 기본형 형식과 참조형 형식이 다른 결과를 반환한다.
		System.out.println("기본형 형식 : " + (str == "ABCDE"));//true
		System.out.println("기본형 형식 : " + (str1 == "ABCDE"));//false
		
		//equals 비교 : 기본형 형식과 참조형 형식이 같은 결과를 반환한다.
		System.out.println("equals 기본형 형식 : " + ("ABCDE".equals(str)));//true
		System.out.println("equals 기본형 형식 : " + ("ABCDE".equals(str1)));//true
		
		System.out.println(str.length());
		
		str1="cpfl688@naver.com";
		int leng=str1.length();
		
		System.out.printf("%s는 %d자\n", str1, leng);
		
		str="abCdeF";
		
		System.out.println(str + "을 모두 대문자로 : " + str.toUpperCase());
		System.out.println(str + "을 모두 소문자로 : " + str.toLowerCase());
		
		
		System.out.println(str.charAt(3));
		char c=str.charAt(1);
		System.out.println(str + "에서 1번째 인덱스의 문자 : " + c);
		
		//자신의 메일 주소에서 @을 변수에 저장하여 출력.
		c=str1.charAt(7);
		System.out.println(c);
		
		//문자열 안에서 특정 문자열의 시작인덱스를 얻기.
		str="Java Oracle JDBC";
		System.out.println(str + "에서 'r'의 인덱스 " + str.indexOf("r"));
		System.out.println(str + "에서 \"Ora\"의 인덱스 " + str.indexOf("Ora"));
		
		//존재하지 않는 문자열은 -1이 나온다.
		System.out.println(str + "에서 \"ora\"의 인덱스 " + str.indexOf("ora"));
		
		//같은 문자열이 있다면 처음 문자열의 인덱스만 나온다.
		System.out.println(str + "에서 \"a\"의 인덱스 " + str.indexOf("a", str.indexOf("a")+1));//두번째 a인덱스를 얻는다.
		
//		int index=str.indexOf("a");
//		int idx=str.indexOf("C");
//		System.out.println(index + " " + idx);
		
		//문자열 안에서 특정 문자열의 인덱스 얻기 ( R -> L )
		System.out.println(str + "에서 뒤에서 부터 찾은 'a'의 인덱스 " + str.lastIndexOf("a"));
		
		String str2=str.concat(" HTML");//문자열 합치기
		System.out.println(str2);
		
		//Java Oracle JDBC HTML
		String str3=str2.substring(5,11);//Oracle
		System.out.println(str3);//제일 마지막 문자에 끝문자를 덮어씀
		
		//str1="cpfl688@naver.com";
		//str1에서 메일 주소(로컬파트)를 얻기
		//str1에서 도메인 파트(TLD - Top Level Domain)잘라내어 출력
		str3=str1.substring(0,str1.indexOf("@"));
		
		//시작 인덱스만 설정하면 문자열의 끝까지 잘라냄
		//String str4=str1.substring(8);
		String str4=str1.substring(str1.indexOf("@")+1);
		System.out.println(str3 + " " + str4);
		
		boolean flag=str2.startsWith("Java");
		System.out.println(str2 + "은 Java로 시작했는가? " + flag);
		
		boolean flag2=str2.startsWith("java");
		System.out.println(str2 + "은 java로 시작했는가? " + flag2);
		
		//문자열로 시작하는지
		String name="이명화";
		if(name.startsWith("이")) {
			System.out.println(name + "님은 '이'씨 입니다.");
		}else {
			System.out.println(name + "님은 '이'씨가 아닙니다.");			
		}
		
		//문자열로 끝나는지
		String addr="서울시 강남구 역삼동";//인천광역시 부평구 부평리
		if(addr.endsWith("동")) {
			System.out.println("도시");
		}else {
			System.out.println("시골");
		}
		
		//문자열을 포함하는지
//		str3="오늘은 Java를 공부하였다.";
//		str3="Java는 WORA가 특징인 완벽한 OOP언어 입니다.";
		str3="오늘도 긴시간 함께 공부하시느라 고생 많으셨Java.";
		if(str3.contains("Java")) {
			System.out.println(str3+" 안에는 \"Java\"가 포함되어있음");
		}else {
			System.out.println(str3+" 안에는 \"Java\"가 없음");			
		}
		
		
		String mail1="test@test.com";
		String mail2="testtest.com";
		String mail3="test@testcom";
		
		//아래의 method를 호출하여 mail1~3을 넣고 유효한지를 출력
		UseString us=new UseString();
		us.mail(mail1);
		us.mail(mail2);
		us.mail(mail3);

		
	}//main
	
	//mail주소를 입력받아 유효한 메일인지, 무효한 메일인지를 판단하는 method 작성
	//유효한 메일은 7자 이상이면서 @과 .이 포함되어야한다. 그러면 유효 메일을 출력,
	//그렇지 않으면 무효메일 출력
	public void mail(String m) {
		if(m.length()>=7 && m.indexOf("@")!=-1 && m.indexOf(".")!=-1) {
			System.out.println(m + " : 유효메일");			
		}else {
			System.out.println(m + " : 무효메일");
		}
	}
	

}//class
