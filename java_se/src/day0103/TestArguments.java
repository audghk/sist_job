package day0103;

/**
 * main method arguments 입력과 사용에 대한 연습. 실행) java day0103.TestArguments 값 값 값
 */
public class TestArguments {

	public static void main(String[] args) {

		System.out.println(args[0]);// ctrl + shift + f 하면 정리해줌
		System.out.println(args[1]);
		System.out.println(args[2]);
		//문자열 String은 연산되지 않는다. (붙임)
		System.out.println(args[0] + args[1]);
		
		//int i=args[0]; //참조형을 기본형에 할당할 수 없다.
		//int i=(int)args[0]; //String을 기본형으로 강제형변환 할 수 없다.
		
		//문자열을 정수로 변환하는 일(method)을 하는 method를 사용. "11" -> 11
		int num=Integer.parseInt(args[0]);
		int num2=Integer.parseInt(args[1]);
		System.out.println(num + num2);
		

	}

}
