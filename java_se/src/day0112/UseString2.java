package day0112;

/**
 * 문자열 클래스의 사용
 */
public class UseString2 {

	public static void main(String[] args) {

		String fileName="Test.txt.bat";
		System.out.println("파일명 : " + fileName.substring(0,fileName.lastIndexOf(".")));
		System.out.println("확장자 : " + fileName.substring(fileName.lastIndexOf(".")+1));
		
		
		String str="";//""로 초기화 => String 클래스에서 제공하는 instance method를 사용할 수 있다.
		String str1=null;//null로 초기화 => String 클래스에서 제공하는 instance method는 사용할 수 없다.
		
		System.out.println(fileName + "는 비었니? " + fileName.isEmpty());
		System.out.println(str + "는 비었니? " + str.isEmpty());
		
//		System.out.println(str1 + "는 비었니? " + str1.isEmpty());//error
		//null로 초기화된 객체의 method를 호출하면 error가 발생.
//		if(str==null) {
//			System.out.println("str 객체가 생성되지 않았음");//죽은 코드 dead code -> 코딩 잘못한거
//		}else {
//			System.out.println("str 객체가 생성됨");
//		}	
		if(str1==null) {
			System.out.println("str 객체가 생성되지 않았음");
		}//else {
//			System.out.println("str 객체가 생성됨");//죽은 코드 dead code -> 코딩 잘못한거
//		}
		
		str="   A BC   ";
		String temp=str.trim();//문자열의 앞뒤 공백 제거
		System.out.printf("[%s][%s]\n", str, temp);
	
		str="Java Oracle JDBC JSON";
		temp=str.replace("J", "j");
		temp=str.replaceAll("J", "j");//결과는 똑같다.
		
		String msg="나 지금 피시방인데, 넌 어디니 시방새야";
		String filter=msg.replaceAll("시", "*").replaceAll("방","*").replaceAll("ㅆ","*");
		System.out.println(msg + " 변경된 문자열 : " + filter);
		
		//method를 연속하여 호출하는 chain문법은 반환형을 확인한 후 사용한다.
		temp=msg.concat("데헷").replaceAll("시방", "**").trim().toUpperCase();
		System.out.println(temp);
		
		msg="내 전화번호는 010-1234-5678 내 친구 전번은 010-2345-4321 내 나이는 20살";
		temp=msg.replaceAll("\\d","*");//숫자를 *로 바꿈
		System.out.println(temp);
		
		msg="내 전화번호는 010-1234-5678 내 친구 전번은 010-2345-4321" +
			"내 나이는 20살 이전 전화번호는 011-123-2345 태어난 해는 1995년" +
			"집 전화번호는 02-123-2452 아! 듀얼번호는 010-2245-2533";
		temp=msg.replaceAll("(\\d{3})-(\\d{4})-(\\d{4})","xxx-xxxx-xxxx");
		System.out.println(temp);
		
		msg="내 전화번호는 010-1234-5678 내 친구 전번은 010-2345-4321\n" +
				"내 나이는 20살 이전 전화번호는 011-123-2345 태어난 해는 1995년\n" +
				"집 전화번호는 02-123-2452 아! 듀얼번호는 010-2245-2533";
		temp=msg.replaceAll("(\\d{3})-(\\d{4})-(\\d{4})","$1-xxxx-$3");//그룹1(\\d{3}) -> $1
		System.out.println(temp);
		
		msg="전화번호는 010-1234-5678임";
//		temp=msg.replaceAll("(\\d{3})-(\\d{1})(\\d{3})-(\\d{4})","$1-x$3-$4");//그룹4개
		temp=msg.replaceAll("(\\d{3}-)\\d{1}(\\d{3}-\\d{4})","$1x$2");//그룹2개
		System.out.println(temp);//010-x234-5678
		
		msg="내 메일 주소는 test@daum.net 과 Hello12 Java test@sist.co test@sist.co.kr";
//		temp=msg.replaceAll("[a-z]", "");//소문자
//		temp=msg.replaceAll("[A-Z]", "");//대문자
//		temp=msg.replaceAll("[0-9]", "");//숫자
//		temp=msg.replaceAll("[ㄱ-힣]", "");//한글
//		temp=msg.replaceAll("[da]", "");//범위(-)가 아니면 각각의 문자가 된다.
		temp=msg.replaceAll("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", "xxxx@xxx.xxx");
		System.out.println(temp);
		
		
		int i=12;
		temp=String.valueOf(i);
//		temp=i + "";//권장하지 않음. 눈에 안보이는 객체가 만들어짐.
		System.out.println(temp);
		
		double d=2024.01;
		temp=String.valueOf(d);
		System.out.println(temp);
		
		
		String csvData="Java,Oracle,JDBC,HTML,CSS,JavaScript";
		String[] arr=csvData.split(",");
		
		for(String data : arr) {
			System.out.println(data);
		}
		
		String[] arr2="어쩔.저쩔.뇌절.안물.안궁.개킹받쥬".split("[.]");//그냥해서 안잘리면 정규식 그룹지어서 자르기
		for(String data : arr2) {
			System.out.println(data);
		}
		
		
	}

}
