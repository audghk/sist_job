package day1226;
//지역변수 사용
class UseLocalVariable{

	int i; //instance variable //class field

	//main method : 클래스를 단독으로 실행시켜야할 때 정의하는 method
	//단독으로 실행가능한 프로그램 : java application
	public static void main(String[] args){

		//지역변수
		//선언: 데이터형 변수명 -> int maxScore; 초기화 되지않은 변수
		int maxScore = 100; //초기화 값
		int myScore = 0; //초기화 되지 않은 변수
		System.out.println(myScore); //초기화 되지 않은 변수를 사용하면 error발생

		//값할당: 변수명 = 값 -> maxScore = 10;
		maxScore = 100;
		myScore = 90;

		//값사용: 출력 -> System.out.println(a);
		System.out.println(maxScore - myScore);
		System.out.print("최고점수 " + maxScore + "점, 내 점수 " + myScore + "점");
		System.out.println(", 최고 점수간의 차이: " + (maxScore - myScore) + "점");
		
		maxScore = 100;
		myScore = 95;
		System.out.print("최고점수 " + maxScore + "점, 내 점수 " + myScore + "점");
		System.out.println(", 최고 점수간의 차이: " + (maxScore - myScore) + "점");

		//1. 올해를 저장할 수 있는 변수를 선언하고 초기값으로 올해를 할당
		//2. 자신의 나이를 저장할 수 있는 변수를 선언하세요
		//3. 2번의 변수에 자신의 나이를 할당하세요
		//4. 두개의 변수를 사용하여 자신이 태어난 해를 연산하여 출력

		int year = 2023;
		int myAge;
		myAge = 25;
		System.out.println("태어난 해: " + (year - myAge) + "년");

		//int myScore=10000; //영역이 같다면 같은 이름의 변수는 하나만 선언가능 error 발생
		//int i; //영역이 다르므로 같은 이름의 변수를 선언할 수 있음

	}//main

}//class