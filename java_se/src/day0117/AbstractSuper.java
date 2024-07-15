package day0117;

/**
 * 추상클래스 : 직접 객체화 될 수 없다.
 */
public abstract  class AbstractSuper {

	public AbstractSuper() {
		super();
		System.out.println("부모 기본 생성자");
	}
	
	public void test() {
		System.out.println("일반 instance method");
	}
	
	public abstract String msg(); //body가 없음 => 추상 method
	public abstract String msg(String msg); //body가 없음 => 추상 method
	
//	public static void main(String[] args) {
//		new AbstactSuper(); //직접 객체화 될 수 없다.
//		
//	}
	
	
}
