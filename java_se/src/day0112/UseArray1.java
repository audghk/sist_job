package day0112;

/**
 * 일차원 배열) 열로만 구성된 배열
 * 1. 선언)
 *  데이터형[] 배열명=null;
 * 2. 생성)
 *  배열명=new 데이터형[방의크기];
 * 1+2) 데이터형[] 배열명=new 데이터형[방의크기];
 * 3. 값 할당) - 존재하지 않는 배열 인덱스를 사용하면 error 발생
 *  배열명[방의번호]=값;
 * 4. 값 사용)
 *  배열명[방의번호]
 *  
 * 일괄처리(한번에 처리)
 * - 방의 수 : 배열명.length
 * for(int i=0; i<배열명.length; i++){
 *  배열명[i];
 * }
 */
public class UseArray1 {

//	int[] arr; //default값으로 null이 들어간다.
	public UseArray1() {
		//1. 선언)
		int[] arr=null;
		
		//2. 생성) - heap에 생성되고, 모든 방의 값은 0으로 초기화된다.
		arr=new int[5];
		
		//3. 값할당)
		arr[0]=2024;
		arr[1]=1;
		arr[2]=12;
		arr[3]=14;
		arr[4]=23;
//		arr[5]=1;//존재하지 않는 index를 사용하면 error
		
		
		System.out.println(arr + ", 방의 수 : " + arr.length + "개");
		System.out.println("처음 방 : " + arr[0] + ", 두번째 방 : " + arr[1]);
	
		//4. 값 얻기)
		System.out.println(arr[0]+" ~ "+arr[4]);
		
		//5. 일괄처리(한꺼번에 처리)
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
			sum+=arr[i];
		}
		System.out.println(sum);	
	}
	
	public void scoreProcess() {
		
		System.out.println("강아지 조아");
//		String[] nameArr=new String[4];
		String[] nameArr= {"루피","샹크스","나미", "조로", "쵸파"};
		String[] addrArr= {"서울시 강남구 역삼동","서울시 동대문구 동대문동","인천시 미추홀구", "서울특별시 구로구 구로동", "수원시 영통구 영통동"};
		int[] scoreArr= {94, 96, 75, 83, 100};//new int[]를 생략
//		int[] scoreArr=new int[] {94, 96, 75, 83, 100};//new int[] 명시
//		int[] scoreArr=new int[5] {94, 96, 75, 83, 100};//방의 크기를 설정하면 error

		
		System.out.printf("번호\t이름\t점수\t주소\n");
		
		int total=0;
		for(int i=0; i<nameArr.length; i++) {
			System.out.printf("%d\t%s\t%d\t%s\n", i+1, nameArr[i], scoreArr[i], addrArr[i]);
			total+=scoreArr[i];
		}
		System.out.println("-----------------------");
		System.out.printf("총점 [%d]점, 평균[%.2f]점\n", total, total/(double)nameArr.length);
		
		int sum=0;
		int cnt=0;
		for(int i=0; i<nameArr.length; i++) {
			
//			if(addrArr[i].startsWith("서울")) {
			if(addrArr[i].indexOf("서울")!=-1) {
				sum+=scoreArr[i];
				cnt++;
			}
		}
		System.out.println(sum + ", " + (double)sum/cnt);
		
		
		System.out.println("-----------------------");
		
		//scoreArr의 마지막번째 방부터 출력
		for(int i=scoreArr.length-1; i>-1; i--) {
			System.out.printf("%d ", scoreArr[i]);
		}
		
		System.out.println("\n-----------------------");
		
		//flowchart를 코드로 옮겨보세요. 가장 큰수 출력
		int[] scoreArr1={94, 96, 75, 83, 100};
		
		int top=scoreArr1[0];
		
		for(int i=0; i<scoreArr1.length; i++) {
			if(top<scoreArr1[i]) {
				top=scoreArr1[i];
			}
		}
		System.out.println(top);
		
		//가장 작은수 출력
		int small=scoreArr1[0];
		for(int i=0; i<scoreArr1.length; i++) {
			if(small>scoreArr1[i]) {
				small=scoreArr1[i];
			}
		}
		System.out.println(small);
		
		System.out.println("-----------------------");
		
		//flowchart를 코드로 옮겨보세요.
		int temp=0;
		for(int i=0; i<scoreArr.length-1; i++) {
			for(int j=i+1; j<scoreArr.length; j++) {
				if(scoreArr[i]<scoreArr[j]) {
					temp=scoreArr[i];
					scoreArr[i]=scoreArr[j];
					scoreArr[j]=temp;
				}
			}
		}
		for(int i=0; i<scoreArr.length; i++) {
			System.out.println(scoreArr[i]);
		}
		
		
	}//scoreProcess
	
	
	
	
	public static void main(String[] args) {

//		UseArray1 ua=new UseArray1();
//		ua.scoreProcess();
		new UseArray1().scoreProcess();
		
		
	}

}
