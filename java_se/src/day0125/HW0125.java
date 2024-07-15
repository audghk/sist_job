package day0125;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;

import day0125.WorkVO2;

public class HW0125 {

	private Map<Integer, String> map;
	private Set<Integer> set;
	private List<WorkVO2> list;



	public HW0125() {
		
	}
	
	public void inputMenu() {
		boolean exitFlag=false;
		String inputData="";
		String[] inputArr=null;
		
		do {
			inputData=JOptionPane.showInputDialog("메뉴\n1.입력 2.검색 3.종료");
		
			if("1".equals(inputData)) {
				inputMenu2(inputArr);
			}else if("2".equals(inputData)) {
				printData();
			}else if("3".equals(inputData)) {
				exitFlag=false;
			}else {
				JOptionPane.showMessageDialog(null, "잘못입력했습니다.");
			}
		
		
		
		}while(!exitFlag);
	}
	
	public void inputMenu2(String[] inputArr) {
		
		JOptionPane.showInputDialog("학생의 정보를 아래와 같이 입력해주세요.\n예)학생번호,이름,자바점수,오라클점수");
		
	}

	private void inputData(String[] inputArr) {
		
		int stNum = Integer.parseInt(inputArr[0]);
		String name = inputArr[1];
		int java = Integer.parseInt(inputArr[2]);
		int oracle = Integer.parseInt(inputArr[3]);
		
		WorkVO2 vo2=new WorkVO2(stNum, name, java, oracle);
		
		map.put(vo2.getStNum(),vo2.getName());
		set.add(vo2.getJava());
		set.add(vo2.getOracle());
		
	}
	
	public void printData() {
		System.out.println("번호\t이름\t자바\t오라클\t총점");
		WorkVO2 wVO2 = null;
		for (int i = 0; i < 5; i++) {
			wVO2 = list.get(i);
			System.out.print(wVO2.getStNum() + "\t" + wVO2.getName() + "\t" + wVO2.getJava() + "\t" + wVO2.getOracle() + "\t"
					+ (wVO2.getOracle() + wVO2.getJava()) + "\n");
		}
	}// end printData

	public static void main(String[] args) {

		HW0125 hw=new HW0125();
		hw.inputMenu();
		
	}

}
