package day0104;

/**
 * for문 : 시작과 끝을 알때 사용하는 반복문
 * 문법)
 * for(시작값 ; 조건식(끝값) ; 증,감소식){
 *  반복수행될 문장들...
 * }
 */
public class TestFor {

	public static void main(String[] args) {

		//안녕하세요를 10번 출력하는 코드 작성.
		for(int i=0; i<10; i++) {
			System.out.println("안녕하세요? " + i);
		}
		
		//1에서부터 100까지 옆으로 출력하는 코드 작성.
		for(int i=1; i<101; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		//0에서부터 100까지 홀수만 옆으로 출력하는 코드 작성.
		for(int i=0; i<101; i++) {
			if(i%2==1) {
				System.out.print(i + " ");
			}
		}
		System.out.println();

		for(int i=1; i<100; i+=2) {//증감식은 대상체의 값을 변화시키고 저장할 수 있는 모든 연산자를 사용할 수 있다.
			System.out.print(i + " ");
		}
		System.out.println();
		
		//100에서부터 1까지 옆으로 출력하는 코드 작성.
		for(int i=100; i>0; i--) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(int i=1; i<10; i++) {
			System.out.println("4 X " + i + " = " + i*4);
		}
		System.out.println("---------------------------");
		
		//main method에서 처음 입력된 값이 구구단의 범위였을 때(2~9단)
		//해당 단의 구구단을 출력하는 코드 작성.
		if(Integer.parseInt(args[0])>1 && Integer.parseInt(args[0])<10) {
			for(int i=1; i<10; i++) {
				System.out.println(args[0] + " X " + i + " = " + Integer.parseInt(args[0])*i);
			}
		}else {
			System.out.println("잘못입력했습니다.");
		}
		
		//1~100까지의 합 출력. -> 누적합
		int sum=0;
		for(int i=1; i<101; i++) {
			sum+=i;
		}
		System.out.println(sum);

		
		
	}

}
