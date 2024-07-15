package day1227;
class  Casting{

	/*
	강제형변환 : 개발자가 필요한 데이터 형으로 일시적 변환을 하는 것.
	-원본 값은 유지되지만, 상황에 따라 값 손실이 발생할 수 있다.
	-기본형에서 참조형으로, 참조형에서 기본형으로는 casting 될 수 없다.
	-boolean은 동일형으로만 casting 될 수 있다.
	*/
	public static void main(String[] args) {

		double d=2023.12;
		//int i=d; //크기와 값의 종류가 다르므로 error 발생
		//casting 문법 : (변환할데이터형)값;
		int i=(int)d;//실수가 정수로 변환되니 값 손실이 발생하게된다.
		System.out.println("원본 값 : " + d + ", casting한 값 : " + i);

		float f=(float)1.234;//리터럴의 값을 4byte로 변환하여 할당
		System.out.println(f);

		byte num1=10;
		byte num2=20;
		byte result=0;
		result=(byte)(num1+num2);//casting을 통해서 연산결과를 result변수에 할당
		System.out.println(num1 + " + " + num2 + " = " + result);

		char c='0'; //문자 0
		System.out.println(c + "의 unicode는 " + (int)c);

		//boolean은 boolean으로만 casting이 가능하다.
		boolean b=true;
		boolean b1=(boolean)b; //의미 없음.
		System.out.println(b + ", " + b1);
		//int ii=(int)b; //다른 형으로는 casting 불가.
		//기본형을 참조형으로, 참조형을 기본형으로 casting 불가.
		//int today=27; //int 기본형 데이터형
		//String strToday=(String)today; //String : 참조형 데이터형
		//String strToday="27"; //참조형
		//int intToday=strToday; //기본형

		//연습문제
		//1. Exam1227.java를 생성한다.
		//-아래와 같이 출력하는 코드를 작성해 보세요.
		//출력 1. 내 이름은 이명화 이고 이니셜은 L, M, H입니다. 태어난 해는 1998년으로 나이는 25살입니다.
		char initial1='L';
		char initial2='M';
		char initial3='H';
		int myYear=1998;
		int thisYear=2023;
		int myAge=thisYear-myYear;

		System.out.println("내 이름은 이명화 이고 이니셜은 " + initial1 + ", " + initial2 + ", " + initial3 + "입니다.");
		System.out.println("태어난 해는 " + myYear + "년으로 나이는 " + myAge + "살 입니다.");

		//출력 2. 왼눈 시력 1.2 오른 눈 시력 1.2이고 양안 시력 ((왼눈 + 오른눈)/2)입니다.
		double leftEye=1.2;
		double rightEye=1.2;
		double eyes=(leftEye + rightEye)/2;
		
		System.out.println("왼눈 시력 " + leftEye + "이고 오른 눈 시력 " + rightEye +"이고 양안 시력은 " + eyes + "입니다.");
		
		//출력 3. 편도차비는 3500원 왕복차비는 편도차비*2원, 한달 20일 출근하면 월 교통비는 총 (왕복차비*20)원 입니다.
		int oneWay=3500;
		int roundTrip=oneWay*2;
		int total=roundTrip*20;
		
		System.out.println("편도차비는 " + oneWay + "원이고 왕복차비는 " + roundTrip +"원, 한달 20일 출근하면 월 교통비는 총 " + total + "원 입니다.");

		//출력 4. 대문자 'A'의 Unicode 값은 65입니다. A에 32를 더하면 소문자 'a'를 만들 수 있다.
		char alphabet='A';
		int small=alphabet + 32;
		System.out.println("대문자 '" + alphabet + "'의 Unicode 값은 65입니다. A에 32를 더하면 소문자 '" + (char)small + "'를 만들 수 있다.");

		//각 항목에 부합되는 데이터형을 사용하여 변수를 선언하고, 연산하여 출력해보세요.



	}//main
}//class
