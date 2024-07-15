package day0108;

/**
 * 시작과 끝을 모를 때 사용하는 반복문
 * 최소 0번 수행에 최대 조건까지 수행
 * 문법
 * while(조건식){
 *  반복 수행할 문장들...
 * }
 */
public class TestWhile {

	public static void main(String[] args) {

		int i=0;
//		while(i<10) {
//			System.out.println("i = "+ i);
//			i++;
//		}
		
		//구구단 5단 출력
		while(i<9) {
			i++;
			System.out.println("5 X " + i + " = " + i*5);
		}
		
		
	}

}
