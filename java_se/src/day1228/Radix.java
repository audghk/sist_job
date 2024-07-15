package day1228;
/*
진수 사용
*/

class Radix{
	public static void main(String[] args) {

		int i=10; //10진수 -> 2진수로 저장
		int j=012; //8진수 -> 2진수로 저장
		int k=0xA; //16진수 -> 2진수로 저장
		
		System.out.println(i + j + k); //2진수를 연산하여 10진수로 보여준다.


		int i1=89;
		int i2=300;

		System.out.println(Integer.toBinaryString(i1) + " " + Integer.toBinaryString(i2));
		System.out.println(i1 + " " + i2);

		int a=030;
		int b=0201;
		int c=0300;

		System.out.println(Integer.toBinaryString(a) + " " + Integer.toBinaryString(b) + " " + Integer.toBinaryString(c));
		System.out.println(a + " " + b + " " + c);

		int a1=0x25;
		int a2=0x1D;
		int a3=0xFF;

		System.out.println(Integer.toBinaryString(a1) + " " + Integer.toBinaryString(a2) + " " + Integer.toBinaryString(a3));
		System.out.println(a1 + " " + a2 + " " + a3);

		System.out.println(Integer.toOctalString(i1) + " " + Integer.toHexString(i1));

		int tel=01012341234; //0으로 시작하는 수는 8진수.
		System.out.println("내 전화번호는 : " + tel);
		//8진수를 출력하면 10진수로 나온다. => 문자열로 저장


	}//main
}//class
