package day0104;

/**
 * 다양한 for의 형태.
 * 
 * -무한루프
 * for(초기값 ; ; 증,감소식){
 * }
 * 
 *  for( ; ; ){
 *  }
 */
public class TestFor3 {

	public static void main(String[] args) {
		
		//증가하는 수를 세는 무한루프
		System.out.println("무한루프");
		for(int i=0; ; i++) {
			System.out.println(i);
			if(i==50) {
				break;
			}
		}
		
		
		//증가하는 수를 세지않는 무한루프
//		for(;;) {
//			System.out.println("무한루프");
//		}
		//System.out.println("무한루프"); //무한루프 아래의 코드는 실행될 수 없기 때문에 error
		
		//여러개의 초기값을 가지는 for
		for(int i=0, j=10, k=2; i<10; i++, j--, k*=2) {
			System.out.println(i + " " + j + " " + k);
		}
		
		//continue
		//1~100까지 홀수만 출력.
		for(int i=1; i<100; i++) {
			if(i%2==0) {//짝수 건너뛰어
				continue;
			}
			System.out.print(i + " ");
		}
		
		
		
	}

}
