package day0124;

import java.awt.FlowLayout;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
//1. 윈도우 컴포넌트 상속
public class UseFlowLayout extends JFrame {

	public UseFlowLayout() {
		super("flowLayout 연습");
		//2. 컴포넌트 생성
		JLabel jlblName=new JLabel("이름");
		JTextField jtfName=new JTextField(10);
		JCheckBox jbcSave=new JCheckBox("저장");
		JButton jbtnInput=new JButton("입력");
		
		//3. 배치관리자 생성(Non-Visual Component)
		setLayout(new FlowLayout());
		
		//4. 컴포넌트 배치
		add(jlblName);
		add(jtfName);
		add(jbcSave);
		add(jbtnInput);
	
		//5. 윈도우 크기 설정
		setSize(500,400);
		
		//6. 사용자에게 보여주기
		setVisible(true);
		
		//7. 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}
	
	public static void main(String[] args) {

		new UseFlowLayout();
		JOptionPane.showInputDialog("학생의 정보를 아래와 같이 입력해주세요.\n예)학생번호,이름,자바점수,오라클점수");
		JOptionPane.showMessageDialog(null, "메시지 다이얼로그");
		
	}

}
