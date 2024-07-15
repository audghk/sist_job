package day0125;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;
import static java.lang.Integer.parseInt;

/**
숙제.
 - InputDialog를 사용하여 아래와 같은 동작을 수행하는 프로그램을 작성하세요.

 1. 입력, 검색, 종료 메뉴를 받을 수 있는 Dialog를 제공한다.





2. 위의 Dialog에서 “1”이 입력 되면 학생번호,이름,자바,오라클 점수를 입력 받을 수 있는
   InputDialog를 제공한다. 
   CSV형식의 데이터를 입력받아, 학생의 번호가 존재한다면 “이미 존재하는 번호입니다.”
  를 MessageDialog에 보여주세요. 그렇지 않으면 VO에 입력.





3.1번 메뉴에서 “2”가 입력되면 저장된 모든 값을 console에 출력하는 코드 작성
  번호 이름 자바점수 오라클점수 합계 평균
    1   xxx    90           90           90  90.xx

4. 1메뉴에서 “3” 이 입력되면 프로그램을 종료한다.
 
 */
public class Homework0124 {
	
	public static final int INPUTD_DATA = 1;
	public static final int PRINT_DATA = 2;
	public static final int END_PROGRAM = 3;
	
	public static final int NUM = 0;
	public static final int NAME = 1;
	public static final int SCORE_JAVA = 2;
	public static final int SCORE_ORACLE = 3;
	
	public static final int NUM_OF_INDEX = 4;

	
	
	
	private Map<Integer, WorkVO> map;
	private boolean flagEnd;	
	
	/**
	 * 생성자
	 */
	public Homework0124() {
		flagEnd = false;
		map = new HashMap<Integer, WorkVO>();
	} // Exam0124
	
	
	/**
	 *  1. 입력, 검색, 종료 메뉴를 받을 수 있는 Dialog를 제공한다.
	 */
	public void inputMenu() {
		String inputData="";
		do {
			inputData = JOptionPane.showInputDialog("메뉴\n1.입력 2.출력 3.종료");
			if (inputData != null && !"".equals(inputData)) {	// 취소 버튼의 작동 배제
				if("1".equals(inputData)) {
					inputData();
				}
				if("2".equals(inputData)) {
					printData();
				}
				if("3".equals(inputData)) {
					endProgram();
				}
									
			} // end if
		} while (!flagEnd);
	} // inputData
	
	/**
	 * 2. 위의 Dialog에서 “1”이 입력 되면 학생번호,이름,자바,오라클 점수를 입력 받을 수 있는
	   InputDialog를 제공한다. 
	   CSV형식의 데이터를 입력받아, 학생의 번호가 존재한다면 “이미 존재하는 번호입니다.”
	  를 MessageDialog에 보여주세요. 그렇지 않으면 VO에 입력.
	 */
	public void inputData() {
		String inputData = JOptionPane.showInputDialog("학생의 정보를 아래와 같이 입력해주세요\n예) 학생번호,이름,자바점수,오라클점수");
		if (inputData != null) {
			String[] arr = inputData.split(","); 
			switch(arr.length) {
			case NUM_OF_INDEX:
				
				int num = Integer.parseInt(arr[NUM]);
				if(!map.containsKey(num)) {
					map.put(num, new WorkVO(num, arr[NAME], parseInt(arr[SCORE_JAVA]), parseInt(arr[SCORE_ORACLE])));
				} else {
					JOptionPane.showMessageDialog(null,num+"번 이미 존재하는 번호입니다");
				} // end else
			}
		} // end if
		
	} // inputData
	
	
	/**
	 * 3.1번 메뉴에서 “2”가 입력되면 저장된 모든 값을 console에 출력하는 코드 작성
	  번호 이름 자바점수 오라클점수 합계 평균
	    1   xxx    90           90           90  90.xx
	 */
	public void printData() {
		
		WorkVO wVO = null;
		
		StringBuilder sb = new StringBuilder("번호\t이름\t자바점수\t오라클점수\t합계\t평균\n");
		DecimalFormat df = new DecimalFormat("###.00");
		
		
		
		
		///////////////// 정렬 알고리즘 1: Collections.sort() 사용 /////////////////////////
		//
		//
//		List<Integer> list = new LinkedList<Integer>(map.keySet());
//		Collections.sort(list, Collections.reverseOrder());//오름차순
		Set<Integer> set = map.keySet();
		Integer[] arr=new Integer[set.size()];
		set.toArray(arr);
		Arrays.sort(arr);
		
		// 출력할 문자열을 StringBuilder에 저장
		for (int i = 0; i < arr.length; i++) {
			wVO = map.get(arr[i]);
			sb.append(wVO.getNum()).append("\t").append(wVO.getName()).append("\t")
			.append(wVO.getScoreJava()).append("\t\t").append(wVO.getScoreOracle()).append("\t\t")
			.append(wVO.getScoreJava() + wVO.getScoreOracle()).append("\t")
			.append(df.format((wVO.getScoreJava() + wVO.getScoreOracle()) / 2.0)).append("\n");
		} // end for
		//
		//
		//////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		///////////////// 정렬 알고리즘 2: 배열 + 이중for 사용 //////////////////////////////
		//
		//
//		Set<Integer> set = map.keySet();
//		Integer[] arr = new Integer[set.size()];
//		set.toArray(arr);
//		
//		int temp = 0;
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = i + 1; j < arr.length; j++) {  
//				if(arr[i] > arr[j]) {
//					temp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = temp;
//				} // end if
//			} // end for
//		} //end for
//		
//		// 출력할 문자열을 StringBuilder에 저장
//		for (int i = 0; i < arr.length; i++) {
//			wVO = map.get(arr[i]);
//			sb.append(wVO.getNum()).append("\t").append(wVO.getName()).append("\t")
//			.append(wVO.getScoreJava()).append("\t\t").append(wVO.getScoreOracle()).append("\t\t")
//			.append(wVO.getScoreJava() + wVO.getScoreOracle()).append("\t")
//			.append(df.format((wVO.getScoreJava() + wVO.getScoreOracle()) / 2.0)).append("\n");
//		} // end for
		//
		//
		///////////////////////////////////////////////////////////////////////////////////////
		
		
		
				

		// 출력
		System.out.println(sb.toString());
		
	} // printData
	
	
	
	/**
	 * 4. 1메뉴에서 “3” 이 입력되면 프로그램을 종료한다.
	 */
	public void endProgram() {
		flagEnd = true;
	} // endProgram

	public static void main(String[] args) {
		new Homework0124().inputMenu();

	} // main

} // class
