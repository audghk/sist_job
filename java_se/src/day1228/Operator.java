package day1228;
/*
단항 연산자: 연산에 필요한 항이 하나인 연산자.
~, !, +, -, ++, --
*/

class Operator{
	public static void main(String[] args) 	{

	// ~ : tilde - 1의 보수 연산
	// ~양수 : 부호변경 1증가, ~음수 : 부호변경 1감소
	
	int i=10, j=-10;

	System.out.println("~" + i + " = " + ~i); //~10 => -11
	System.out.println("~" + j + " = " + ~j); //~-10 => 9

	//~를 사용하여 부호만 변경하고 싶다.
	System.out.println(~(i - 1));
	
	i=11;
	j=28;

	System.out.println(i < j);
	System.out.println(!(i < j)); //!은 true나 false 앞에서만 정의 가능

	boolean flag1=true, flag2=false;
	System.out.println("!" + flag1 + " = " + !flag1);
	System.out.println("!" + flag2 + " = " + !flag2);

	i=12;
	j=-12;

	System.out.println("-" + i + " = " + -i);
	System.out.println("-" + j + " = " + -j);

	i=5;
	j=10;

	System.out.println("설정된 값 " + i + ", " + j);	
	
	++i;
	--j;
	++i;
	--j;

	System.out.println("전위연산 후 : i = " + i + ", j = " + j);

	i++;
	j--;

	System.out.println("후위연산 후 : i = " + i + ", j = " + j);

	//전위와 후위는 대입연산과 함께 사용되면 각자 다른 값을 대입한다.
	i=10;
	int result=0;

	//전위연산 : 내 것 먼저.(단항을 수행한 후 대입을 수행)
	result=++i;

	System.out.println("전위 후 result : " + result + ", i : " + i);

	i=10;

	//후위연산 : 남의 것 먼저.(대입을 수행한 후 단항을 수행)
	result=i++;

	System.out.println("후위 후result : " + result + ", i : " + i);

	i=10;
	j=10;

	System.out.println("전위 : " + ++i + " 후위 : " + j++);
	System.out.println("method 호출 후 i : " + i + ", j : " + j);

	}//main
}//class
