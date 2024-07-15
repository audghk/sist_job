package day0124;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import day0119.CSVData;
//		String inputData = JOptionPane.showInputDialog("이름을 입력해 주세요");
//		StringBuilder sb = new StringBuilder();
//		public static void main(String[] args) {
//		if("윤웅찬".equals(inputData)) {
//			sb.append("조원동의 자랑 ");
//		}
//		sb.append(inputData).append("님");
//		System.out.println(sb);

public class Homework {

//	List<WorkVO> list = new ArrayList<WorkVO>();
	private List<WorkVO> list;
	private static final int CSV_DATA = 3;

	public Homework() {
		list = new ArrayList<WorkVO>();
	}

//	static StringTokenizer st;//필요없다아~!~!
	int cnt = 0;
//	int num = 1;

	/**
	 * 메뉴를 입력 받아서 CSV데이터인지, 출력, 종료 인지를 판단하여 해당 method를 호출하는 일.
	 */
	public void inputMenu() {

		boolean exitFlag = false;
		String inputData = "";
		String[] inputArr = null;// CSV데이터를 저장할 배열

		do {// while보다 do while이 더 적합.
			inputData = JOptionPane.showInputDialog("이름,자바점수,오라클점수 입력\n출력을 입력하면 출력됩니다.\n중료하실려면 Y,y를 눌러주세요");
			if (inputData != null) {
//			if(inputData.matches(("[a-zA-Zㄱ-힣]+,(\\d{1,}),(\\d{1,})"))) {
//				st = new StringTokenizer(inputData,",");
				inputArr = inputData.split(",");
				switch (inputArr.length) {
				case CSV_DATA:
					inputData(inputArr);
				default:
					if ("출력".equals(inputData)) {
						printData();
					}
					exitFlag = "Y".equals(inputData) || "y".equals(inputData);
////					if("Y".equals(inputData) || "y".equals(inputData)) {
////						char key=inputData.charAt(0);
////						exitFlag=exitProgram(key);//Y 또는 y가 들어가면 true가 나와서 저장됨~
////					}
				}// end switch

//				 for (int i = 0; i < 3; i++) {
//					    if (st.hasMoreTokens()) {
//					        inputArr[i] = st.nextToken();
//					    } 
//					}
//				this.inputData(inputArr);
//				
//			} else if(inputData.equals("출력")) {
//				this.printData();
//				
//			} else if(inputData.equals("Y")||inputData.equals("y")) {
//				this.exitProgram();
//			}

			}
		} while (!exitFlag);
	}

	public void inputData(String[] inputArr) {
		String name = inputArr[0];
		int java = Integer.parseInt(inputArr[1]);
		int oracle = Integer.parseInt(inputArr[2]);

		WorkVO vo = new WorkVO(name, java, oracle);

		list.add(vo);
	}

	/**
	 * 출력 메서드
	 */
	public void printData() {
		System.out.println("번호\t이름\t자바\t오라클\t총점");
		WorkVO wVO = null;
		for (int i = 0; i < list.size(); i++) {
			wVO = list.get(i);
			System.out.print((i + 1) + "\t" + wVO.getName() + "\t" + wVO.getJava() + "\t" + wVO.getOracle() + "\t"
					+ (wVO.getOracle() + wVO.getJava()) + "\n");
		}
	}// end printData

	/**
	 * 종료 메서드
	 */
//	private void exitProgram() {
//		System.exit(0);//쓰면 안됨~~~~~~~~~~ 자바에 있는 모든 인스턴스들을 죽임!(어플리케이션이면 괜찮음 웹은 안돼~~~)
//	}
	public boolean exitProgram(char key) {
		return key == 'Y' || key == 'y';
	}

	public static void main(String[] args) {

		Homework hm = new Homework();
		hm.inputMenu();
	}
}
