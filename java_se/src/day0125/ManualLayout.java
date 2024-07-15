package day0125;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class ManualLayout extends JFrame {

	public ManualLayout() {
		super("수동배치");
		
		JButton jbtn=new JButton("버튼");
		String[] dataArr= {"자장면","김밥","백반", "뼈해장국","순대국밥","돈까스","을밀대 냉면"};
		JList<String> jl=new JList<String>(dataArr);
		
		JPasswordField jpf=new JPasswordField();
		
		//배치관리자 해제
		setLayout(null);
		
		//컴포넌트의 크기설정
		jbtn.setSize(80,30);
		jl.setSize(150,120);

		//컴포넌트의 위치 설정
		jbtn.setLocation(50,130);
		jl.setLocation(160,210);
		
		//컴포넌트의 크기와 위치를 한번에 설정하는 method : setBounds(x, y, w, h)
		jpf.setBounds(360,40,120,40);
		
		//배치
		add(jbtn);
		add(jl);
		add(jpf);
		
		setSize(600,600);//java.awt.Window클래스에서 Override
		setLocation(300,150);//시작좌표가 Frame 안쪽이 아닌 모니터 좌상단
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {

		new ManualLayout();
		
	}

}
