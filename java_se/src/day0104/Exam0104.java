package day0104;

public class Exam0104 {

	public static void main(String[] args) {

		//1. 구구단 전체 단을 옆으로 출력
		for(int i=1; i<10; i++) {
			for(int j=2; j<10; j++) {
				System.out.print(j + " X " + i + " = " + i*j + "    ");
			}
			System.out.println();
		}
		System.out.println("--------------");

		
		//2. 아래와 같은 형태로 숫자 앞에 공백을 넣어서 출력.
		//0
		// 1
		//  2
		//   3
		//    4
		//     5
		for(int i=0; i<6; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			System.out.println(i);
		}
		System.out.println("--------------");
		
		//3. 1에서부터 100까지의 수 중 3의 배수 합을 출력.
		int sum=0;
		for(int i=1; i<101; i++) {
			if(i%3==0) {
				sum+=i;
			}
		}
		System.out.println(sum);
		
		
		
		
		
		
		
		
		
		
		
	}

}
