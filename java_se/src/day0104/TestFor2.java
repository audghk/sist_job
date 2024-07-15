package day0104;

/**
 * 다중 for : 인덱스를 두개 사용하여 반복해야할 때.
 * 문법)
 * for(초기값; 조건식; 증.감소식){
 *  반복수행문장 //다중 for의 영역
 *  for(초기값; 조건식; 증.감소식){
 *   반복수행문장 //다중 for의 영역
 *  }
 *  반복수행문장 //다중 for의 영역
 * } 
 * 
 */
public class TestFor2 {

	public static void main(String[] args) {
		
		//다중 for의 동작 : 바깥 for가 한번 반복할 때, 안쪽 for는 몇 번 반복하는가?
		for(int i=0; i<5; i++) {//5번반복
			for(int j=0; j<3; j++) {//3번반복
				System.out.println("i : " + i + ", j : " + j);
			}//end for
			System.out.println("------------");
		}//end for
		
		
		//구구단
		for(int i=2; i<10; i++) {
			System.out.println("-----" + i + "단-----");
			for(int j=1; j<10; j++) {
				System.out.println(i + " X " + j + " = " + i*j);
			}
		}
		
		//0 0
		//1 0 1 1
		//2 0 2 1 2 2
		//3 0 3 1 3 2 3
		//안쪽 for가 0에서부터 시작하여 바깥 for의 현재 번째까지 반복
		for(int i=0; i<4; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(i + " " + j + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		
		//0 1 0 2 0 3 0 4 0 5
		//1 2 1 3 1 4 1 5
		//2 3 2 4 2 5
		//3 4 3 5
		//4 5
		//안쪽 for의 시작이 바깥 for의 현재보다 1큰 지점에서 5까지 반복
		for(int i=0; i<5; i++) {
			for(int j=i + 1; j<6; j++) {
				System.out.print(i + " " + j + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		//1
		//2 3
		//4 5 6
		//7 8 9 10
		int k=1;
		for(int i=0; i<4; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(k++ + " ");
			}
			System.out.println();
		}
		
		
		
	}

}
