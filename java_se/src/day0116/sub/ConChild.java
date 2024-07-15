package day0116.sub;

/**
 * 생성자에 this와 super를 적절하게 사용하여 아래와 같이 출력되도록 만들어보세요.
 * 1. 부모의 인자 생성자 2024 > 부모의 기본생성자 > 자식의 기본 생성자 > 자식의 인자생성자 10
 * 2. 부모의 기본 생성자 > 부모인자 100 > 자식인자 100 > 자식의 기본 생성자
 *  (    오른쪽에서 왼쪽으로 읽어나가면 편하다~   <==    )
 */
public class ConChild extends ConParent{

	public ConChild() {
//		super();//무조건 기본으로 숨어있음 => 부모클래스
//		super();//1-3
		this(100);//2-2
		System.out.println("자식의 기본생성자");
	}
	public ConChild(int i) {
//		super();//무조건 기본으로 숨어있음 => 부모클래스
//		this();//1-2
		super(100);//2-3
		System.out.println("자식의 인자 생성자 "+i);
	}
	
	public static void main(String[] args) {
		
//		new ConChild(100);//자식의 인자 생성자 100
//		new ConChild(10);//1-1
		new ConChild();//2-1

		
		
		
	}
	
}
