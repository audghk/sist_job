package day0108;

/**
 * 시작과 끝을 모를 때 사용하는 반복문.
 * 최소 1번 수행에 최대 조건까지 수행
 * 문법)
 * do{
 * 반복수행문장들..
 * }while(조건식);
 */
public class TestDoWhile {

	public static void main(String[] args) {

		int i=1000;
		do {
			
			System.out.println("i = " + i);
			i++;
			
		}while(i<10);
		
		
		//1~100까지 합
		
		int j=0;
		int sum=0;
		do {
			
			sum+=j;
			j++;
			
		}while(j<101);
		System.out.println(sum);
		
		
	}

}
