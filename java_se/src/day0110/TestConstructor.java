package day0110;

/**
 * 생성자 연습.
 * - 생성자는 직접 호출 불가능하고, new(객체 생성용 키워드)로만 호출 가능.
 * - 생성자를 반환형 없이, 클래스의 이름과 동일하게 생성.
 */
public class TestConstructor {//인스턴스 영역

	/**
	 * 매개변수 없는 기본 생성자!! 
	 */
	public TestConstructor() {// 괄호가 있으면 생성자 없으면 클래스
		System.out.println("default constructor!! 기본 생성자");
	}
	
	/**
	 * 매개변수 있는 생성자
	 * @param i
	 */
	public TestConstructor(int i) {
		System.out.println("overload된 constructor!! 생성자의 다형성");
		
	}
	
	public void test() {//instance method
		System.out.println("나는 test method");
//		temp();
	}
	public void temp() {//instance method
		System.out.println("나는 temp method");
		test();//영역이 같다면 객체명 없이 직접 호출 가능.
//		TestConstructor();//생성자는 직접 호출 불가능 error
		new TestConstructor();
	}
	
	public static void main(String[] args) {//static 영역

		//생성자 호출.
		new TestConstructor();//객체화
		TestConstructor tc= new TestConstructor();
		tc.temp();
		//temp()는 인스턴스 영역 main은 static 영역으로 영역이 다르기 때문에
		//static 영역에서 인스턴스 영역의 method를 호출하려면 객체화를 하여 호출한다.
		TestConstructor tc2= new TestConstructor(2024);
		tc2.temp();
		
	}

}
