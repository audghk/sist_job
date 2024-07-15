package day0108.sub;

import day0108.TestAccessModifier2;

/**
 * 패키지가 다른 상태에서 public 접근 지정자가 있는 클래스의 접근
 * UsePublicModifier2는 TestAccessModifier2의 자식 클래스
 */
public class UsePublicModifier2 extends TestAccessModifier2{

	public static void main(String[] args) {

		UsePublicModifier2 upm2=new UsePublicModifier2();
		//UsePublicModifier2 클래스는 부모클래스(TestAccessModifier2)에 존재하는
		//public, protected에 대해서 접근 할 수 있다.
		upm2.a=100;// public
		upm2.b=100;// protected
//		upm2.c=100;// default 사용불가
//		upm2.d=100;// private 사용불가
		
	
	
	}

}
