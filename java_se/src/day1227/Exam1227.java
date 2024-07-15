package day1227;
class Exam1227{
	public static void main(String[] args) {
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
	}
}
