package day0109;

/**
 * V.A를 사용하여 console에 출력하는 method
 * System.out.format(), System.out.println() - 출력 후 줄 변경을 하지 않는다.
 */
public class UseVariableArguments2 {

	public static void main(String[] args) {

		int year=2024, month=1, day=9;
		System.out.println("오늘은 " + year + "년 " + month + "월 " + day + "일");
		System.out.printf("오늘은 %d년 %d월 %d일 입니다.\n", year, month, day);
		System.out.format("오늘은 %d년 %d월 %d일 입니다.\n", year, month, day);
		
		System.out.printf("정수 출력 : [%d][%5d][%-5d]\n", 19, 19, 19);
		System.out.printf("문자 출력 : [%c][%5c][%-5c]\n", 'A', 'A', 'A');
		System.out.printf("불린 출력 : [%b][%5b][%-5b]\n", true, true, true);
		System.out.printf("실수 출력 : [%f][%5.1f][%-5.2f][%.3f]\n", 2024.0193, 30.2, 1.4524, 2024.0193);
		System.out.printf("문자열 출력 : [%s][%10s][%-10s]\n", "안녕하세요?", "안녕하세요?", "안녕하세요?");
				
		String name="이명화";
		int javaScore=99;
		int oracleScore=97;
		int htmlScore=95;
		
		//아래와 같이 출력 (평균은 소수점 이하 1자리까지만 출력)
		//xxx님 Java SE xx점, Oracle xx점, HTML xx점
		//총점 : xx점, 평균 : xx점
		
		System.out.printf("%s님 Java SE %d점, Oracle %d점, HTML %d점\n", name, javaScore, oracleScore, htmlScore);
		System.out.printf("총점 : %d점, 평균 : %.1f점", javaScore+oracleScore+htmlScore, (javaScore+oracleScore+htmlScore)/3.0);
		
		
	}

}
