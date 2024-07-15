package day0116;

/**
 * Parent의 자식 클래스. 공통특징은 부모에서 제공하는 것을 사용하고, 나 자신의 특징적인 일을 구현하여 사용
 */
public class Child extends Parent{

	String name;
	String msg;
	
	public Child() {
		System.out.println("자식의 생성자 "+this);
//		System.out.println("자식의 생성자 "+super);//error 보안상 부모의 시작 주소 막아놔서 못찍음
		msg="이 편지는 아프리카에서부터 시작되었음.";
	}
	
	
	
	/**
	 * 자식의 method
	 * @return
	 */
	public String getName() {
		return name;
	}


	/**
	 * 자식의 method
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void printMsg() {
		System.out.println("자식 : "+this.msg);//this 생략가능
//		System.out.println("자식 : "+super.msg);//부모의 메시지를 출력
//		printMsg();//재귀호출 => 내가 나를 계속 부름
		super.printMsg();//부모의 method 호출
	}

	

	public static void main(String[] args) {

		//상속 관계에서는 자식 클래스로 객체화 한다. => 부모가 먼저 만들어진다.
		Child c=new Child();
		
		//코드의 재사용성. (부모가 가진 변수나 method를 자식에서 자신의 객체명(c)로 사용할 수 있는 것)
		c.setAge(20);//코드의 재사용성
		System.out.println(c.getAge());
		c.setName("이명화");
		System.out.println(c.getAge());//코드의 재사용성
		System.out.println(c.getName());
		
		c.printMsg();
		
	}

}
