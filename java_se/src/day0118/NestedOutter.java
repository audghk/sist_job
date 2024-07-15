package day0118;

/**
 * nested class
 * 	안쪽클래스를 static 변수처럼 사용할 때.(객체화 없이 직접 사용할 때)
 */
public class NestedOutter {

	int outI;
	static int outJ;
	
	public NestedOutter() {
		System.out.println("바깥클래스의 생성자");
	}
	public void outInsMethod() {
		System.out.println("바깥클래스의 인스턴스 method");
	}
	public static void outStaMethod() {
		System.out.println("바깥클래스의 스태틱 method");
	}
	
	////////////nested class 시작////////////////
	static class Inner{//일반클래스 아님 => 일반 클래스의 접근지정자는 public과 package 두개밖에 없음 //생성자를 만들지 않는다.
		
		//변수나 method는 static으로 만들어 객체없이 사용하도록 한다.
		static int inI;
		
		public static void inMethod() {
			System.out.println("안쪽 클래스의 method");
//			outI=10;//instance 영역의 변수는 사용할 수 없다.
//			outInsMethod();//instance 영역의 method는 사용할 수 없다.
			outJ=20;
			outStaMethod();
		}
		
	}//Inner class
	
	////////////nested class 끝/////////////////
	
	public static void main(String[] args) {

		Inner.inMethod();//Nested class는 객체 없이 클래스명으로 직접 사용할 수 있다.		
		
	}

}
