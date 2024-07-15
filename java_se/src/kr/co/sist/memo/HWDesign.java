package kr.co.sist.memo;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class HWDesign extends JFrame {

	public HWDesign() {
		JLabel jlblName=new JLabel("이름");
		JTextField jtfName=new JTextField(10);
		JComboBox<String> jcbGender=new JComboBox<String>();
		jcbGender.addItem("남자");
		jcbGender.addItem("여자");
		JButton jbtnInput=new JButton("입력");
		
		JTextArea jtaList=new JTextArea();

		JPanel jpNorth=new JPanel();
		jpNorth.add(jlblName);//JPanel에 컴포넌트를 배치
		jpNorth.add(jtfName);//JPanel에 컴포넌트를 배치
		jpNorth.add(jcbGender);//JPanel에 컴포넌트를 배치
		jpNorth.add(jbtnInput);//JPanel에 컴포넌트를 배치
		
		
		add("North", jpNorth);
		add("Center", jtaList);

		
		add("Center",jtaList);
		
		setSize(450,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {

		new HWDesign();
		
	}

}
