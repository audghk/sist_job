package day1227;
/*
기본형 데이터 형 : 변수에 상수값을 저장하는 데이터형.
*/
class  PrimitiveDataType{
	public static void main(String[] args) {
		//////////////정수상수를 저장할 수 있는 데이터형////////////
		byte a=10; //byte는 -128 ~ +127
		//byte b=128; //데이터 형은 저장할 수 있는 범위를 초과하면 error발생
		short b=10; // short는 -32768 ~ +32767
		int c=10;
		long d=10;

		//자신이 평생 모으고싶은 현실적인 자산을 변수에 할당
		long money=999999999L; //리터럴의 크기를 변경하여 사수를 저장하고, 변수에 할당                                                                                                                                                                                                                                                                                                                                                                                                                  
		//long money=2147483647;

		System.out.println("byte : " + a + ", short : " + b + ", int : " + c + ", long : " + d + ", 자산 : " + money);

		///////////////char형//////////////
		//A b 9 z //유니코드 alt + 숫자
		char e='A'; //문자에 해당하는 2byte의 unicode값이 할당
		char f='0';
		char g='가';
		char h='\u0000'; //unicode 0
		System.out.println("char : " + e + f + g + h);
		System.out.println("sdfkddkl");

		////////////////////실수형/////////////////////
		//float f=12.27; //실수 리터럴은 8byte이고, float형은 4byte이기 때문에 크기가 같지 않아서 값이 할당될 수 없다.
		float i=12.27F; //8byte의 리터럴이 4byte로 축소되어 할당된다.
		float j=12.27f;

		double k=2023.12D;

		System.out.println("float : " + i + j + ", double : " + k);

		//////////////////////boolean///////////////
		boolean l=true; //true false 이외의 값은 저장할 수 없다.
		boolean m=false;
		System.out.println("boolean : " + l + m);
	}
}