package day1227;
/*
Constant : 변수를 상수처럼 사용할 때 사용.
*/

class ConstantTest{
	//constant의 정의
	public static final int MAX_SCORE=100; //기준값 -> constant는 값을 변경할 수 없다.
	public static final int MIN_SCORE=20;

	public static void main(String[] args) 	{

		//int maxScore=100;
		int myScore=80;
		//maxScore=99; //기준값은 변경되면 안됨
		
		
		System.out.println("많은 코드들");
		System.out.println("많은 코드들");
		System.out.println("많은 코드들");
		System.out.println("많은 코드들");
		System.out.println("많은 코드들");

		System.out.println("최고 점수와 획득점수간의 차 " + (MAX_SCORE - myScore));
		System.out.println("최고 점수와 획득점수간의 차 " + (ConstantTest.MAX_SCORE - myScore)); // 클래스 명 써주는 것을 권장

	}//main
}//class
