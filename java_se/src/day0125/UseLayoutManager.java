package day0125;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
//1. Window Component 상속
public class UseLayoutManager extends JFrame{

	public UseLayoutManager() {
		super("여러 레이아웃 메니저 사용");
		//2. 컴포넌트 생성
		JLabel jlblName=new JLabel("이름");
		JTextField jtfName=new JTextField(10);
		JComboBox<String> jcbGender=new JComboBox<String>();
		jcbGender.addItem("남자");
		jcbGender.addItem("여자");
		JButton jbtnInput=new JButton("입력");
		
		//글꼴 적용
		//1. Font 클래스 생성
		Font font=new Font("궁서체", Font.BOLD, 20);
		
		jlblName.setFont(font);
		jtfName.setFont(font);
		jcbGender.setFont(font);
		jbtnInput.setFont(font);
		
		//글자색 => 상수
		jlblName.setForeground(Color.BLUE);
		//RGB
		Color color=new Color(0xFF8FBE);
		jtfName.setForeground(color);
		jcbGender.setForeground(color);
		jbtnInput.setForeground(color);

		//바닥이 투명한 컴포넌트는 투명도를 설정해야한다.
		jlblName.setOpaque(true);
		jlblName.setBackground(new Color(0xFFDBE0));
		
		JTextArea jtaList=new JTextArea();
		jtaList.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 20));
		jtaList.setForeground(new Color(0xFFDBE0));
		jtaList.setBackground(Color.GRAY);
		
		//3. 배치
		//BorderLayout은 하나의 영역에 하나의 컴포넌트만 배치된다.
		// Container Component 필요
//		add("North",jlblName);
//		add("North",jtfName);
//		add("North",jcbGender);
//		add("North",jbtnInput);
		
		//여러개의 컴포넌트를 관리하기 위해서 Container Component를 사용.
		JPanel jpNorth=new JPanel();
		jpNorth.add(jlblName);//JPanel에 컴포넌트를 배치
		jpNorth.add(jtfName);//JPanel에 컴포넌트를 배치
		jpNorth.add(jcbGender);//JPanel에 컴포넌트를 배치
		jpNorth.add(jbtnInput);//JPanel에 컴포넌트를 배치
		
		//윈도우 컴포넌트(Window)
		add("North", jpNorth);
		add("Center", jtaList);

		
		add("Center",jtaList);
		
		setSize(450,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {

		new UseLayoutManager();
		
	}

}
