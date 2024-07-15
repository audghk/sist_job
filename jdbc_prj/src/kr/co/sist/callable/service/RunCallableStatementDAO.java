package kr.co.sist.callable.service;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import kr.co.sist.callable.dao.CallableStatementDAO;
import kr.co.sist.prepared.dao.PreparedStatementDAO;
import kr.co.sist.statement.dao.StatementDAO;
import kr.co.sist.statement.vo.EmployeeVO;
import kr.co.sist.vo.ResultVO;
import oracle.net.aso.j;
import oracle.net.aso.m;

import static java.lang.Integer.parseInt;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import static java.lang.Double.parseDouble;

/**
 * CRUD를 사용하는 클래스
 */
public class RunCallableStatementDAO {

	public void addEmp() {
		String inputData = JOptionPane.showInputDialog("추가할 사원정보를 입력해주세요.\n사원번호, 사원명, 직무, 연봉");
		if (inputData != null) {
			String[] tempData = inputData.split(",");
			if (tempData.length != 4) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요.");
				return;
			}

			// 입력된 데이터를 하나로 묶어서 관리
			try {
				EmployeeVO eVO = new EmployeeVO(parseInt(tempData[0]), tempData[1], tempData[2],
						parseDouble(tempData[3]), null);
				// DB에 추가하면 된다.
				CallableStatementDAO csDAO=CallableStatementDAO.getInstance();
				try {
					ResultVO rVO=csDAO.insertEmployee(eVO);
					if(rVO.getCnt()==1) {
						JOptionPane.showMessageDialog(null, tempData[0] + "번 사원정보가 추가 되었습니다.");
					}else {
						JOptionPane.showMessageDialog(null, rVO.getErrMsg());
					}
				} catch (SQLException se) {
					se.printStackTrace();
					JOptionPane.showMessageDialog(null,"DBMS에서 문제가 발생");					
				}
				}catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "사원번호나 연봉은 숫자형태이어야합니다.");
				}
			}
		}

	public void modifyEmp() {
		String inputData = JOptionPane.showInputDialog("사원정보 변경\n사원번호,직무,연봉을 입력하면 사원번호에 해당하는 사원의 직무와 연봉을 변경합니다.");
		if (inputData != null) {
			String[] tempData = inputData.split(",");
			if (tempData.length != 3) {
				JOptionPane.showMessageDialog(null, "입력은 사원번호,직무,연봉의 형식입니다.");
				return;
			}

			try {
				EmployeeVO eVO = new EmployeeVO(parseInt(tempData[0]), null, tempData[1], parseDouble(tempData[2]),
						null);

				// DBMS테이블의 update를 수행
//				PreparedStatementDAO psDAO=PreparedStatementDAO.getInstance();
//				int cnt=psDAO.updateEmp(eVO);
				CallableStatementDAO csDAO=CallableStatementDAO.getInstance();
				
				ResultVO rVO=csDAO.updateEmployee(eVO);
				
				int cnt=rVO.getCnt();
				
				String msg = tempData[0] + "번 사원은 존재하지 않습니다. 사원번호를 확인해주세요.";
				if (cnt != 0) {// 1건 이상 변경 되었을 때
					msg = tempData[0] + "번 으로 " + cnt + "건 변경 되었습니다.";
				}

				JOptionPane.showMessageDialog(null, msg);

			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호와 연봉은 숫자형태 입니다.");
			} catch (SQLException se) {
				se.printStackTrace();

				String errMsg = "";
				switch (se.getErrorCode()) {
				case 1438:
					errMsg = "연봉은 정수 5자리, 실수 2자리로 입력 가능합니다.";
					break;
				case 12899:
					errMsg = "직무는 한글 3자까지만 가능합니다.";
					break;
				default:
					errMsg = "문제가 발생하였습니다.";
				}
				JOptionPane.showMessageDialog(null, errMsg);
			}
		}

	}

////////////////////////////////////////////////////////////////////////////////////////////////////
	public void removeEmp() {
		String inputData = JOptionPane.showInputDialog("사원삭제\n삭제할 사원번호를 입력해주세요.");
		if (inputData == null) {
			JOptionPane.showMessageDialog(null, "사원번호를 입력해주세요.");
			return;
		}

		// 유효성 검증(사원번호는 숫자 4자리)
		if (inputData.length() > 4) {
			JOptionPane.showMessageDialog(null, "사원번호는 4자리입니다.");
			return;
		}

		try {
			int empno = parseInt(inputData);// 사원번호의 범위 : 0~9999사이

			// DBMS에서 조회된 결과를 받아서 사용자에게 보여준다.
			CallableStatementDAO csDAO=CallableStatementDAO.getInstance();
			
			ResultVO rVO=csDAO.deleteEmployee(empno);
			
			int cnt=rVO.getCnt();
			
			String msg=inputData+"번 사원번호를 확인하세요.";
			if(cnt!=0) {
				msg=inputData+"번 사원정보가 "+cnt+"건 삭제되었습니다.";
			}
//			JOptionPane.showMessageDialog(null, msg);

			try {
				csDAO.deleteEmployee(cnt);
				JOptionPane.showMessageDialog(null, empno + "번 사원정보가 삭제 되었습니다.");
			} catch (SQLException se) {
				se.printStackTrace();
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원번호는 4자리 입니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"삭제 중 문제가 발생했습니다.");
		}

	}

////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void searchAllEmp() {

		// DBMS에서 조회된 결과를 받아서 사용자에게 보여준다.
		PreparedStatementDAO psDAO=PreparedStatementDAO.getInstance();
		try {
			List<EmployeeVO> listAllEmp = psDAO.selectAllEmp();
//			System.out.println(listAllEmp);
			StringBuilder output = new StringBuilder();
			output.append("사원번호\t사원명\t직무\t연봉\t입사일\n");
			if (listAllEmp.isEmpty()) {
				output.append("데이터가 없습니다.");
			} else {
				for (EmployeeVO eVO : listAllEmp) {
					output.append(eVO.getEmpno()).append("\t").append(eVO.getEname()).append("\t").append(eVO.getJob())
							.append("\t").append(eVO.getSal()).append("\t").append(eVO.getHiredate2())
							.append("\n");

				}
			}

			JTextArea jta = new JTextArea(output.toString(), 10, 80);
			JScrollPane jsp = new JScrollPane(jta);
			JOptionPane.showMessageDialog(null, jsp);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void searchOneEmp() {
		String inputData = JOptionPane.showInputDialog("사원검색\n사원번호를 입력해주세요.");
		if (inputData == null) {
			JOptionPane.showMessageDialog(null, "사원번호를 입력해주세요.");
			return;
		}

		try {
			int empno = parseInt(inputData);
			// DBMS에서 조회된 결과를 받아서 사용자에게 보여준다.
			PreparedStatementDAO psDAO=PreparedStatementDAO.getInstance();
			EmployeeVO eVO=psDAO.selectOneEmp(empno);

			StringBuilder output = new StringBuilder();
			output.append(empno).append("번 사원번호 검색 결과\n");
			if (eVO == null) {
				output.append("사원번호를 확인하세요.");
			} else {
				output.append("사원명 : ").append(eVO.getEname()).append("\n");
				output.append("직무 : ").append(eVO.getJob()).append("\n");
				output.append("연봉 : ").append(eVO.getSal()).append("\n");
				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
				output.append("입사일 : ").append(sdf.format(eVO.getHiredate()));
				output.append("입사일2 : ").append(eVO.getHiredate2());
			}

			JTextArea jta = new JTextArea(output.toString(), 10, 80);
			JScrollPane jsp = new JScrollPane(jta);
			JOptionPane.showMessageDialog(null, jsp);

		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원번호는 숫자형태 이어야합니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void menu() {
		boolean exitFlag = false;

		String inputMenu = "";
		do {
			inputMenu = JOptionPane.showInputDialog("CallableStatement 메뉴 선택\n1.사원정보추가\n2.사원정보변경\n3.사원정보삭제\n4.전체사원검색\n5.특정사원검색\n6.종료");
			if (inputMenu != null) {
				switch (inputMenu) {
				case "1":
					addEmp();
					break;
				case "2":
					modifyEmp();
					break;
				case "3":
					removeEmp();
					break;
				case "4":
					searchAllEmp();
					break;
				case "5":
					searchOneEmp();
					break;
				case "6":
					exitFlag = true;
					break;
				default:
					JOptionPane.showMessageDialog(null, "메뉴는 1,2,3,4,5,6 중 하나만 입력해 주세요.");
				}
			}

		} while (!exitFlag);
	}

	public static void main(String[] args) {

		RunCallableStatementDAO rsDAO = new RunCallableStatementDAO();
		rsDAO.menu();

	}

}
