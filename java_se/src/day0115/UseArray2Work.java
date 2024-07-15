package day0115;

/**
 * 학생들의 점수를 처리하는 클래스
 */
public class UseArray2Work {

	public void scorePrint() {
		String[] namesArr= {"루피","샹디","쵸파","나미","로빈"};
//		String[] subjectArr= {"루피","샹디","쵸파","나미","로빈"};
		int[][] scoreArr={
				{89,91,86},	
				{91,93,90},	
				{98,100,99},	
				{74,85,83},	
				{88,90,95}	
		};
		
//		scoreArr[0][1]+scoreArr[0][2] //가독성이 떨어짐
//		scoreArr[num][kor]+scoreArr[num][eng] //constant로 가독성 향상시킬 수 있음

		System.out.printf("시험 응시 인원 [%d]명\n", namesArr.length);
		System.out.printf("번호\t이름\t국어\t영어\t수학\t총점\t평균\n");
		System.out.println("----------------------------------------------------");
		
		
//		int sum=0;
		for(int i=0; i<scoreArr.length; i++) {
			System.out.printf("%d\t%s\t",i+1, namesArr[i]);
			for(int j=0; j<scoreArr[i].length; j++) {
				System.out.printf("%d\t", scoreArr[i][j]);
//				sum+=scoreArr[i][j];
			}
			System.out.print(totalScore(scoreArr[i]) + "\t");
			System.out.println(totalScore(scoreArr[i])/3);
		}
//		System.out.println(sum);
		System.out.println("----------------------------------------------------");
		
		
		//오늘의 숙제~!~!
		int sum=0;
		for(int i=0; i<scoreArr.length; i++) {
			for(int j=0; j<scoreArr[i].length; j++) {
				sum+=scoreArr[i][j];
			}
		}
		System.out.printf("\t총점 %d점\n", sum);//각 과목의 총점
		
		int avg=0;
		for(int i=0; i<scoreArr.length; i++) {
			avg+=scoreArr[i][0];
		}
		System.out.printf("\t국어평균 %.2f점\n", (double)avg/scoreArr.length);//국어만 평균
		
		int nameNum=0;
		int top=0;
		for(int i=0; i<scoreArr.length; i++) {
			if(top<totalScore(scoreArr[i])) {
				nameNum=i;
				top=totalScore(scoreArr[i]);
			}
		}		
		System.out.printf("\t1등학생의 번호 [%d], 이름 [%s]\n", nameNum + 1, namesArr[nameNum]);
		
	}//scorePrint

	
	/**
	 * 일차원 배열의 총점을 구하여 반환하는 일
	 * @return 
	 */
	public int totalScore(int[] subjectScore) {
		int total=0;
		for(int score : subjectScore) {
			total+=score;
		}
		return total;
	}
		
	
	public static void main(String[] args) {

		UseArray2Work uaw=new UseArray2Work();
		uaw.scorePrint();

		
	}

}
