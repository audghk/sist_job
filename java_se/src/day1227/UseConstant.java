package day1227;
/*
다른 클래스에 존재하는 Constant 사용.
*/

class  UseConstant{
	public static void main(String[] args) 	{

	System.out.println("최고 점수 : " + ConstantTest.MAX_SCORE);
	System.out.println("최저 점수 : " + ConstantTest.MIN_SCORE);

	System.out.println("Byte의 최고값 : " + Byte.MAX_VALUE + ", Byte의 최저값 : " + Byte.MIN_VALUE);
	

	}//main
}//class
