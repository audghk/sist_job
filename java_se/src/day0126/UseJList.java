package day0126;


import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseJList extends JFrame {

	public UseJList() {
		super("MVC패턴이 도입된 클래스");
		//1. Model 객체 생성
		DefaultListModel<String> dlm=new DefaultListModel<String>();
		
		//2. Model과 has a 관계의 View클래스를 생성
		JList<String> jl=new JList<String>(dlm);
		
		//3. Model 객체를 통해서 값을 할당.
		dlm.addElement("Java");
		dlm.addElement("Oracle DBMS");
		dlm.addElement("JDBC");
		dlm.addElement("HTML");
		dlm.addElement("CSS");
		dlm.addElement("JavaScript");
		
		
		JScrollPane jsp=new JScrollPane(jl);
		
//		jl.setBorder(new TitledBorder("과목명"));//여기보다는
		jsp.setBorder(new TitledBorder("과목명"));//여기에 border를 주는게 더 적합
		
		add(jsp);
		
		setLayout(new GridLayout(1,1));
		
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {

		new UseJList();
		
	}

}
