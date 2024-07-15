package day0124;

import javax.swing.JOptionPane;


/**
 * 1. 입력데이터가 CSV형태(이름, 자바점수, 오라클점수)라면 WorkVO객체를 생성하여
 *    입력 값을 할당하고 java.util.List에 추가하는 작업을 수행하세요.
 *    
 * 2. CSV형태가 아닌 "출력"이 입력되면 java.util.List에 들어있는 값을 모두 다 Console에 출력
 *    번호 이름 자바 오라클 총점
 *     1 이명화 100 100 200
 *     2 홍길동 90 80 170
 * 
 * 3. CSV형태가 아닌 "Y"나 "y" 입력되면 프로그램을 종료한다.
 * 
 */
public class HomeWork1 {
	
	public void inputMenu() {
		String inputData=JOptionPane.showInputDialog("\"이름, 자바점수, 오라클점수\" 입력\n\"출력\"을 입력하면 출력됩니다.\n"
				+ "종료하시려면 \"Y 또는 y\"를 입력해주세요.","홍길동");
		if("출력".equals(inputData)){

		}

	}
	
	public static void main(String[] args) {
		
//		String inputData=JOptionPane.showInputDialog("이름을 입력해주세요.","홍길동");
//		StringBuilder sb=new StringBuilder();
//		if("이명화".equals(inputData)) {
//			sb.append("성복동의 자랑 ");
//		}
//		sb.append(inputData).append("님");
//		System.out.println(sb);
		HomeWork1 hw=new HomeWork1();


		new WorkVO1();
	
	
	
	
	}

}
