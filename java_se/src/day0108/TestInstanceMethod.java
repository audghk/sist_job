package day0108;

/**
 * instance method
 * - instance variable를 사용하여 업무를 처리해야할 때
 * - 객체화 후에 객체명으로 method를 호출
 */
public class TestInstanceMethod {

	int day; //instance variable
	public void printDay() {
		System.out.println(day + "일");
	}
	
	public static void main(String[] args) {

//		TestInstanceMethod.printDay(); //instance method는 클래스명으로 호출할 수 없다.
									   // => instance화 후 객체명.method명으로 호출
		TestInstanceMethod tim=new TestInstanceMethod();//instance화
		
		tim.day=8;//instance variable의 사용
		
		//instance method 호출
		tim.printDay();
		tim.day++;
		tim.printDay();
		
	}

}
