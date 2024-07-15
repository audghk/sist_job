package day0108.sub;

import day0108.TestAccessModifier2;

/**
 * 패키지가 다른 상태에서 public 접근 지정자가 있는 클래스의 접근
 */
public class UsePublicModifier {

	public static void main(String[] args) {

		//TestAccessModifier2는 클래스의 접근 지정자가 public이므로 접근 가능
		TestAccessModifier2 tam=new TestAccessModifier2();
		tam.a=10;//a변수는 접근 지정자가 public 이므로 접근 가능
//		tam.b=10;//b변수는 접근 지정자가 protected 이므로 접근 불가능
//		tam.c=10;//c변수는 접근 지정자가 default 이므로 접근 불가능
//		tam.d=10;//d변수는 접근 지정자가 private 이므로 접근 불가능
		
		//TestAccessModifier는 클래스의 접근 지정자가 package이므로 접근 불가능
//		TestAccessModifier tam=new TestAccessModifier();
	
	
	
	}

}
