package day0125;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
//1. 윈도우 컴포넌트 상속
public class UseGridLayout extends JFrame {

	public UseGridLayout() {
		super("격자 레이아웃");
		//2. 컴포넌트를 생성
		JRadioButton jrbPublic=new JRadioButton("public");
		JRadioButton jrbProtected=new JRadioButton("protected");
		JRadioButton jrbPackage=new JRadioButton("package");
		JRadioButton jrbPrivat=new JRadioButton("private");
		
		JRadioButton jrbNone=new JRadioButton("none");
		JRadioButton jrbSealed=new JRadioButton("sealed");
		JRadioButton jrbNonSealed=new JRadioButton("Non-sealed");
		JRadioButton jrbFinal=new JRadioButton("final");
		
		JCheckBox jcbNone=new JCheckBox("none");
		JCheckBox jcbSealed=new JCheckBox("sealed");
		JCheckBox jcbNonSealed=new JCheckBox("Non-sealed");
		JCheckBox jcbFinal=new JCheckBox("final");
		
		//버튼 그룹으로 라디오 버튼을 묶어야 여러개 중 하나만 선택 가능.
		ButtonGroup bg=new ButtonGroup();
		bg.add(jrbPublic);
		bg.add(jrbProtected);
		bg.add(jrbPackage);
		bg.add(jrbPrivat);
		
		ButtonGroup bg2=new ButtonGroup();
		bg2.add(jrbNone);
		bg2.add(jrbSealed);
		bg2.add(jrbNonSealed);
		bg2.add(jrbFinal);
		
		//3. 배치관리자 생성해서 설정.
		setLayout(new GridLayout(2, 4));
		
		//4. 컴포넌트 배치
		add(jrbPublic);
		add(jrbProtected);
		add(jrbPackage);
		add(jrbPrivat);
		add(jrbNone);
		add(jrbSealed);
		add(jrbNonSealed);
		add(jrbFinal);
		
		add(jcbNone);//체크박스는 여러개가 선택되어야하기 때문에 그룹으로 묶지 않는다.
		add(jcbSealed);
		add(jcbNonSealed);
		add(jcbFinal);
		
		//5. 윈도우 크기 설정
		setSize(400,200);
		
		//6. 가시화
		setVisible(true);
		
		//7. 윈도우 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public static void main(String[] args) {

		new UseGridLayout();
	}

}
