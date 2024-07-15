package day0108;

/**
 * 클래스 하나를 정의하고 아래의 일을 할 수 있는 instance method를 구현하고 호출해보세요.
 * 
 * 1. 자신의 이름을 출력하는 method. 고정 일 - 반환형 없고(void), 매개 변수 없는 형
 * 2. 자신의 이름 중에 "성"을 반환하는 method. 고정 값 - 반환형 있고, 매개변수 없는 형
 * 3. 점수를 입력 받아 점수의 판정을 출력하는 method 작성. 가변 일 - 반환형 없고(void), 매개변수 있는 형
 *   (점수는 0~100 사이 일때만 판정하고 그렇지 않으면 "잘못된 점수" 출력. 0~39:과락, 40~59: 다른 과목을 참조, 60~100: 합격)
 * 4. 문자를 입력받아 해당 문자가 "대문자", "소문자", "숫자"인지를 판단하여 출력하는 method. 가변 일 - 반환형 없고(void), 매개변수 있는 형
 *   (A-대문자, 그 외에는 $-대문자, 소문자, 숫자가 아닙니다.를 출력)
 * 5. 태어난 해를 입력받아 나이를 반환하는 method. 가변 값 - 반환형 있고, 매개 변수 있는 형
 * 6. 3개의 수를 입력받아 가장 "작은수"를 반환하는 일을 하는 method. 가변 값 - 반환형 있고, 매개 변수 있는 형
 */
public class Exam0108 {

	//1번 method
	public void ex1() {
		System.out.println("이명화");
	}

	//2번 method
	public char ex2() {
		char first='이';
		return first;
	}
	
	//3번 method
	public void ex3(int score) {
		
		if(score > -1 && score < 101) {
			if(score > -1 && score < 40) {
				System.out.println("과락");
			}else if(score>39 && score<60) {
				System.out.println("다른 과목을 참조");				
			}else {
				System.out.println("합격");
			}
		}else {
			System.out.println("잘못된 점수");
		}
		
	}
	
	//4번 method
	public void ex4(char a) {
		if(a>47 && a<58) {
			System.out.println("숫자");
		}else if(a>64 && a<91) {
			System.out.println("대문자");			
		}else if(a>96 && a<123) {
			System.out.println("소문자");			
		}else {
			System.out.println("대문자, 소문자, 숫자가 아닙니다.");
		}
	}
	
	//5번 method
	public int ex5(int year) {
		
		int age=2024-year;
		return age;
		
	}
	
	//6번 method
	public int ex6(int num, int num2, int num3) {
		
		int small=0;
		if(num<num2 && num<num3) {
			small = num;
		}else if(num2<num && num2<num3){
			small = num2;
		}else {
			small = num3;
		}
		
		return small;
	}
	
	
	
	
	
	public static void main(String[] args) {

		Exam0108 ex=new Exam0108();
		
		//1번 호출
		ex.ex1();
		
		//2번 호출
		char f = ex.ex2();
		System.out.println(f);
		
		//3번 호출
		ex.ex3(100);
		
		//4번 호출
		ex.ex4('A');
		
		//5번 호출
		int age = ex.ex5(1998);
		System.out.println(age);
		
		//6번 호출
		int small = ex.ex6(3, 2, 1);
		System.out.println(small);
		
	}

}
