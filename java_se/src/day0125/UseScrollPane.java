package day0125;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class UseScrollPane extends JFrame {

	public UseScrollPane() {
		super("스크롤 바 연습");
		
		JTextArea jta=new JTextArea("dkfjslkfjsdlkfjdf");
		JTextArea jta2=new JTextArea();
		//줄단위의 보호
		jta2.setLineWrap(true);
		//단어 단위로 보호(한글은 안됨)
		jta2.setWrapStyleWord(true);
		
		String[] dataArr="자바,오라클,JDBC,HTML,CSS,JavaScript,JavaScript Library,Servlet/JSP,JSON".split(",");
		JList<String> jl=new JList<String>(dataArr);
		
		//BorderLayout => GridLayout으로 배치 관리자 변경.
		setLayout(new GridLayout(1,3));
		
		//스크롤바가 필요한 컴포넌트를 위해 JScrollPane을 생성
		JScrollPane jsp=new JScrollPane(jta);
		JScrollPane jsp2=new JScrollPane(jl);
				
//		add(jta);
//		add(jl);
		add(jsp);
		add(jsp2);
		add(jta2);
		
		setBounds(100,100,400,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	}
	
	public static void main(String[] args) {

		new UseScrollPane();
		
	}

}
