package day1228;
/*
논리연산자
 일반논리 : 여러개의 관계연산자를 붙여서 연산할 때 사용.
 && (AND) - 전항과 후항이 모두 true 일때 만 true 반환
 || (OR) - 전항과 후항이 모두 false 일때 만 false 반환

 비트논리 : 비트를 연산
 & (AND): - 상위비트와 하위 비트가 모두 1일때만 1내림.
 | (OR): - 상위비트와 하위 비트가 모두 0일때만 0내림.
 ^ (XOR): - 상위비트와 하위 비트 둘 중 하나만 1이면 1내림
*/

class Operator5{
	public static void main(String[] args) 	{

		boolean flag=true, flag2=false, flag3=true, flag4=false;

		System.out.println("--------AND-------");
		System.out.println(flag + " && " + flag3 + " = " + (flag && flag3));
		System.out.println(flag + " && " + flag2 + " = " + (flag && flag2));
		System.out.println(flag4 + " && " + flag + " = " + (flag4 && flag));
		System.out.println(flag2 + " && " + flag4 + " = " + (flag2 && flag4));

		System.out.println("--------OR-------");
		System.out.println(flag + " || " + flag3 + " = " + (flag || flag3));
		System.out.println(flag + " || " + flag2 + " = " + (flag || flag2));
		System.out.println(flag4 + " || " + flag + " = " + (flag4 || flag));
		System.out.println(flag2 + " || " + flag4 + " = " + (flag2 || flag4));

		//&& : 전항이 false라면 후항을 연산하지 않는다.
		//|| : 전항이 true라면 후항을 연산하지 않는다.
		flag=false;
		flag2=false;
		flag3=false;

		flag3=(flag=3>2) && (flag2=5<6);
		System.out.println(flag + " && " + flag2 + " = " + flag3);

		flag3=(flag=3<2) && (flag2=5>6);
		System.out.println(flag + " && " + flag2 + " = " + flag3);

		//int octalNum=임의의 한자리의 양의수;//0~9
		//octalNum이 8진수의 범위라면 true를 그렇지 않다면 false를 출력해보세요.

		int octalNum = 1;
		boolean range = octalNum >= 0 && octalNum < 8;

		System.out.println(octalNum + "은 8진수의 범위인가? " + range);

		int i=37, j=14;

		System.out.println(i + " & " + j + " = " + (i & j));
		System.out.println(i + " | " + j + " = " + (i | j));
		System.out.println(i + " ^ " + j + " = " + (i ^ j));

	}
}
