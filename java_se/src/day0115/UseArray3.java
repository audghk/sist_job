package day0115;

/**
 * 삼차원 배열 : 면, 행, 열로 구성된 배열
 * 면의 수 : 배열명.length
 * 행의 수 : 배열명[면의번호].length
 * 열의 수 : 배열명[면의번호][행의번호].length
 */
public class UseArray3 {

	
	public UseArray3() {
		//1. 선언) 데이터형[][][] 배열명=null;
		int[][][] arr3=null;
		//2. 생성) 배열명=new 데이터형[면][행][열];
		arr3=new int[2][2][3];
		//3. 값 할당) 배열명[면][행][열]=값;
		arr3[0][1][1]=2024;
		arr3[1][1][1]=1;
				
		
		//4. 값 얻기 & 일괄처리
		for(int i=0; i<arr3.length; i++) {
			for(int j=0; j<arr3[i].length; j++) {
				for(int k=0; k<arr3[i][j].length; k++) {
					System.out.printf("arr[%d][%d][%d]=%d\t", i, j, k, arr3[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
		
		
		
	}//UseArray3
	
	
	public void useArray3() {
		//기본형 형식의 사용
		int[][][] arr3=new int[][][] {
			{{1,2,3},{4,5,6}},
			{{7,8,9},{10,11,12}}
			};
		System.out.printf("%d면%d행%d열\n", arr3.length, arr3[0].length, arr3[0][0].length);//2면2행3열
		
		//개선된 for
		//3차원 배열의 한면은 이차원배열로 이루어져있다.
		for(int[][] arr2 : arr3) {
			//이차원 배열의 한 행은 일차원 배열로 이루어져있다.
			for(int[] arr1 : arr2) {
				//일차원 배열의 한 열은 단일형으로 이루어져있다.
				for(int value : arr1) {
					System.out.printf("%d\t", value);
				}
				System.out.println();
			}
			System.out.println();
		}
		
		
	}//useArray3
	
	
	public static void main(String[] args) {

		new UseArray3().useArray3();
		
	}

}
