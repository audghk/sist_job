package day1228;
/*
산술 연산자 : +, -, *, /, %
*/

class Operator2{
	public static void main(String[] args) {

		int i=10;
		System.out.println(i + "를 2로 나눈 나머지 : " + (i%2));

		i=11;
		System.out.println(i + "를 2로 나눈 나머지 : " + (i%2));

		int birth=1998;
		System.out.println(birth + "년을 12로 나눈 나머지 : " + (birth%12));

		// 정수 / 정수 = 정수
		int num=10;
		int num2=3;
		System.out.println(num/num2);

		//정수 / 실수 = 실수 : 연산 결과를 실수로 얻으려면 나누는 수 중 하나는 실수이어야한다.
		System.out.println(num/(double)num2);
	}
}
