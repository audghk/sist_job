package day0110;

/**
 * polymorphism (다형성)
 * method overloading : 하나의 클래스 안에서 같은 이름의 method를 여러개 정의 하는 것.
 * 편의성
 */
public class TestOverloading {

	//별 하나 출력하는 일
	public void printStar() {
		System.out.print("★");
	}
//	private int printStar() { //접근 지정자와 반환형은 달라도 된다.
//		System.out.print("☆");
//		return 0;
//	}

	//입력되는 수만큼 별을 옆으로 출력하는 일
	public void printStar(int cnt) {
		for(int i=0; i<cnt; i++) {
			System.out.print("☆");
		}
	}
	
	
	public static void main(String[] args) {

		TestOverloading to=new TestOverloading();
		
		to.printStar(5);//overload된 method 호출
		to.printStar();
		
		
		
	}

}
