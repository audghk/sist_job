package day0104;

/**
 * switch~case 사용 : 일치하는 정수를 비교할 때 사용
 * 문법)
 * switch(변수명){
 * case 상수 : 변수가 상수와 일치했을 때 수행 문장들...;
 * case 상수 : 변수가 상수와 일치했을 때 수행 문장들...;
 * .
 * .
 * default : 변수와 일치하는 상수가 없었을 때 수행될 문장들...;
 * }
 * 
 */
public class TestSwitchCase {

	public static final int GRADE_A_PLUS=10;
	public static final int GRADE_A=9;
	public static final int GRADE_B=8;
	public static final int GRADE_C=7;
	public static final int GRADE_D=6;
	
	public static void main(String[] args) {
		
		int i=1;
		//byte i=30;
		//short i=30;
		//char i='A';
		//String i="ABC";
		
		switch(i) {
		case 32767 : System.out.println("영");
		case 1 : System.out.println("일");
		case 2 : System.out.println("이"); break;
		case 3 : System.out.println("삼");
		default : System.out.println("변수와 일치하는 상수 없음.");
		}//end switch
		
		int score=100;
//		char grade='\u0000';
//		
//		switch(score/10) {
//		case GRADE_A_PLUS:
//		case GRADE_A : grade='A'; break;
//		case GRADE_B : grade='B'; break;
//		case GRADE_C : grade='C'; break;
//		case GRADE_D : grade='D'; break;
//		default : grade='F';		
//		}
		
		char grade=64;
		if(score>=0 && score<=100) {
			switch(score/10) {
			case GRADE_D : grade++;
			case GRADE_C : grade++;
			case GRADE_B : grade++;
			case GRADE_A :
			case GRADE_A_PLUS : grade++; break;
			default : grade+=6;
			}
		}else {
			System.out.println("잘못된 점수입니다.");
		}
		
		System.out.println(score + "점의 학점은 " + grade);
		
	}

}
