package day0118;

import day0117.Clark;

public class UseAnonymous {

	public void testFly(Fly fly) {
		//객체다형성 : fly는 어느때에는 FlyImpl되고, 어느때에는 Clark이 될 수 있다.
		System.out.println("추진력 : " +fly.drivingForce());
		System.out.println("양력 : " +fly.left());
	}//testFly
	
	public static void main(String[] args) {

		//testFly method를 호출해보세요!!
		UseAnonymous ua=new UseAnonymous();
//		ua.testFly(new Fly());//인터페이스는 객체화 될 수 없다.
		ua.testFly(new FlyImpl());// new FlyImpl() => 객체, arguments
		ua.testFly(new Clark());
		
		//클래스 파일(소스코드)를 별도로 만들지 않고, 객체를 생성하여 arguments 값을 할당할 때.
		ua.testFly(new Fly() {

			@Override
			public String drivingForce() {
				return "포항항";
			}

			@Override
			public String left() {
				return "데헷";
			}
			
		});
		
	}
	
}
