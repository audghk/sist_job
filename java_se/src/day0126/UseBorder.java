package day0126;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseBorder extends JFrame {

	public UseBorder() {
		super("Border 연습");
		
		JButton jbtn=new JButton("왼쪽");
		JButton jbtn2=new JButton("오른쪽");
		JButton jbtn3=new JButton("오른쪽2");
	
		JPanel jpLeft=new JPanel();
		JPanel jpRight=new JPanel();
		
		//Border생성하여 설정
//		jpLeft.setBorder(new LineBorder(Color.CYAN));
		jpLeft.setBorder(new LineBorder(new Color(0xffff22)));
		jpRight.setBorder(new TitledBorder("버튼을 클릭해보세요."));
		
//		jbtn3.setBorder(new TitledBorder("나는 버튼"));//일반 컴포넌트에 보더 잘 안줌. 이상해~
		
		jpLeft.add(jbtn);
		jpRight.add(jbtn2);
		jpRight.add(jbtn3);
		
		setLayout(new GridLayout(1,2));
		
		add(jpLeft);
		add(jpRight);
		
		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {

		new UseBorder();
		
	}

}
