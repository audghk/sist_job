package day0126;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class UseJMenuBar extends JFrame {

	public UseJMenuBar() {
		super("메뉴바 연습");
		//1. 메뉴바 생성
		JMenuBar jmb=new JMenuBar();
		
		//2.메뉴 생성
		JMenu jm1=new JMenu("1번 메뉴");
		JMenu jm1_1=new JMenu("1번 메뉴의 하위메뉴");
		JMenu jm2=new JMenu("2번 메뉴");
		
		//3. 메뉴 아이템 생성
		JMenuItem jmi1=new JMenuItem("1번의 하위메뉴 아이템");
		JMenuItem jmi1_1=new JMenuItem("1번의 두번째메뉴 아이템");
		JMenuItem jmi1_2=new JMenuItem("1번의 세번째메뉴 아이템");
		
		JMenuItem jmi2=new JMenuItem("2번의 하위메뉴 아이템");
		JMenuItem jmi2_1=new JMenuItem("2번의 두번째메뉴 아이템");
		
		jm1_1.add("하위메뉴1");
		jm1_1.add("하위메뉴2");
		jm1_1.add("하위메뉴3");
		jm1_1.add("하위메뉴4");
		
		//4. 메뉴 아이템을 메뉴에 배치
		jm1.add(jmi1);
		jm1.addSeparator();//구분해줌
		jm1.add(jm1_1);//메뉴에 메뉴가 배치되면 하위 메뉴를 선택할 수 있다.
		jm1.add(jmi1_1);
		jm1.add(jmi1_2);
		
		jm2.add(jmi2);
		jm2.add(jmi2_1);
		
		//5. 메뉴를 메뉴바에 배치
		jmb.add(jm1);
		jmb.add(jm2);
		
		//6. 메뉴아이템을 메뉴에 배치
		setJMenuBar(jmb);
		
		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {

		new UseJMenuBar();
		
	}

}
