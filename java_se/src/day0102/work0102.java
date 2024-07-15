package day0102;

public class work0102 {

	public static void main(String[] args) {
		//1-1. 두 정수를 저장할 수 있는 변수를 만들고, 임의의 값을 할당한다.
		//1-2. 위의 변수 중에 큰 값을 반환하는 삼항 연산자를 만들어보세요.
		
		int i=5, j=2;
		System.out.println(i > j ? i : j);
		
		
		//2-1. 세 개의 정수를 저장할 수 있는 변수를 만들고, 각각의 변수의 임의의 값을 할당한다.
		//2-2. 세 개의 숫자 중 가장 작은 값을 찾아서 출력하는 코드를 만들어보세요.(삼항 연산자)
		
		int a=31, b=21, c=11;
		System.out.println(a>b ? (b>c ? c : b) : (a>c ? c : a));
		
		
		//3. int temp1=10, temp2=20이 할당된 변수를 선언하고 아래 코드를 작성했을 때 어떤 값이 출력되는지
		// 예상해보고, 어떻게 그런 결과가 나왔는지 주석을 열고 간단히 작성.
		int temp1=10, temp2=20;
		
		System.out.println(++temp1 + temp2--); //전위연산이므로 temp1은 11이 출력되고 후위연산이므로 temp2는 20이 출력됨.
		System.out.println("temp1 : " + temp1 + "temp2 : " + temp2); // 11, 후위연산이 됐으므로 19

		
		//4. Integer.MAX_VALUE Constant를 사용하여 Integer의 하위 2Byte값이 출력 되도록
		// 비트논리 연산자를 사용하여 출력해보세요. (결과 65535가 나와야한다.)
		
		System.out.println(Integer.MAX_VALUE >> 15);
		System.out.println(Integer.MAX_VALUE & 0x0000FFFF);
		
	
	}

}
