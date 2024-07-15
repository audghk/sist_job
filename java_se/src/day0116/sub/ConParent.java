package day0116.sub;

public class ConParent {
//기본생성자를 없애도 error 안남. 기본생성자가 없으면 기본으로 만들어짐 눈에 안보임.
	public ConParent() {
//		super();//=>object 클래스
//		this(2024);//1-4
		System.out.println("부모의 기본생성자");
	}
	
//인자생성자만 생성하면 자식한테 error 발생 => 자식에서 super를 써서 불러주면 error 안남.
	public ConParent(int i) {
		this();//2-4
		System.out.println("부모의 인자 생성자 "+i);
	}
}
