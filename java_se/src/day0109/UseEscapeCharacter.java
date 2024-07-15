package day0109;

/**
 * 특수문자
 * 문자열 안에서 사용하는 기능을 가지는 문자.
 * - \로 시작
 * - 정해진 특수문자 이외의 문자를 사용하면 error 발생
 * 
 */
public class UseEscapeCharacter {

	public static void main(String[] args) {

		//System.out.println("newfile.txt의 경로는 e:\temp\test\newfile.txt");
		//System.out.println("java.txt의 경로는 e:\temp\test\java.txt");//존재하지 않는 특수문자 사용시 error가 발생
		
		System.out.println("오늘 대설 내립니다.\n이 상황이라면 강남역 용자 출현");
		System.out.println("9일\t10일\t11일");
		System.out.println("HTML태그 링크 태그는 <a href='경로'>클릭할 이름</a>이 형식");
		System.out.println("HTML태그 링크 태그는 <a href=\'경로\'>클릭할 이름</a>이 형식");
		System.out.println("\"안녕하세요?\"");
		System.out.println("newfile.txt의 경로는 e:\\temp\\test\\newfile.txt");
		System.out.println("newfile.txt\b");
		System.out.println("newfile.txt\f");
		
	}

}
