package day0102;
/*
대입연산
=,
+=, -=, /=, %=
<<=, >>=, >>>=
&=, |=, ^=
*/

class Operator7{
	public static void main(String[] args) 	{
	//순수대입
		int i=11;
		i=25;//기존의 값이 사라진다.
		System.out.println(i);

		//산술대입 : 기존의 값과 연산 후 연산 결과를 다시 변수에 할당.
		i+=2; //i=i+2;
		i-=20;//i=i-20;
		i*=3;//i=i*3;
		i/=4;//i=i/4;
		i%=3;//i=i%3;
		System.out.println(i);

		//쉬프트 대입.
		i<<=4;
		i>>=1;
		i>>>=2;
		System.out.println(i);
	
		//비트논리대입.
		i&=20;
		i|=15;
		i^=10;
		System.out.println(i);
		
	}
}
