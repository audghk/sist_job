package day0108;

/**
 * static method 작성. (객체화 없이 사용할 수 있는 메소드)
 */
public class TestStaticMethod {

	public static void plus(int num, int num2) {
		
		int result=0;
		result=num+num2;
		
		System.out.println(result);
		
	}
	
	//구구단을 입력받아 구구단의 범위였을 때 출력하는 method 작성, 호출
	public static void gugudan(int i) {// i => 매개변수이면서 지역변수.
		
		//int i=0; //parameter와 동일한 변수는 선언할 수 없다. => 영역이 같기 때문에
		if(i>1 && i<10) {
			for(int j=1; j<10; j++) {
				System.out.println(i + " X " + j + " = " + i*j);
			}
		}else {
			System.out.println("잘못입력했습니다.");
		}
		
	}
	
	public static void main(String[] args) {
		//객체화 없이 바로 호출 가능.
		TestStaticMethod.plus(1, 8); //호출
		TestStaticMethod.gugudan(5);
	}

}
