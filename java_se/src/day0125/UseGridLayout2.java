package day0125;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UseGridLayout2 extends JFrame {

	public UseGridLayout2() {
		super("번호판");
		String[] numArr= {"1","2","3","4","5","6","7","8","9","*","0","#"};
		JButton[] jrbArr=new JButton[numArr.length];
		
//		JButton jb1=new JButton("1");
//		JButton jb2=new JButton("2");
//		JButton jb3=new JButton("3");
//		JButton jb4=new JButton("4");
//		JButton jb5=new JButton("5");
//		JButton jb6=new JButton("6");
//		JButton jb7=new JButton("7");
//		JButton jb8=new JButton("8");
//		JButton jb9=new JButton("9");
//		JButton jb0=new JButton("0");
//		JButton jbSt=new JButton("*");
//		JButton jbSh=new JButton("#");
		
		setLayout(new GridLayout(4,3));
		for(int i=0; i<numArr.length; i++) {
			jrbArr[i]=new JButton(numArr[i]);
			add(jrbArr[i]);
		}
		
//		add(jb1);
//		add(jb2);
//		add(jb3);
//		add(jb4);
//		add(jb5);
//		add(jb6);
//		add(jb7);
//		add(jb8);
//		add(jb9);
//		add(jbSt);
//		add(jb0);
//		add(jbSh);
		
		setSize(500,600);	
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {

		new UseGridLayout2();
		
	}

}
