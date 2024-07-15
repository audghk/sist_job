package day0102;
/*
삼항(조건)연산자
전항 ? 항1 : 항2
*/

class Operator6{
	public static void main(String[] args) 	{

		int num=-1;

		System.out.println(num + "은(는) " + (num >= 0 ? "양수" : "음수"));


		//num이 홀수 인지 짝수인지를 판단하여 출력하는 코드
		int num1=1;
		
		System.out.println(num1 + "은(는) " + (num1%2 == 0 ? "짝수" : "홀수"));


		//점수를 저장하는 변수를 선언하고, 임의의 값을 할당한다.
		//할당된 값이 0~100사이라면 "유효점수"를 출력하고 그렇지 않다면 "무효점수"를 출력하는 코드를 작성.
		int num2=15; //-1, 0 ~ 100, 101 : 경계값 테스트

		System.out.println(num2 >= 0 && num2 <= 100 ? "유효점수" : "무효점수");
		System.out.println(num2 > -1 && num2 < 101 ? "유효점수" : "무효점수"); //크거나같다나 작거나같다 보다는 크다 작다를 사용하는게 더 좋음
		


	}
}
