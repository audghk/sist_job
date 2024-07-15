package day0125;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class UseImageIcon extends JFrame {

	public UseImageIcon() {
		super("이미지 연습");
		
		ImageIcon ii=new ImageIcon("E:/dev/workspace/java_se/src/day0125/img1.png");// 복사하고 ctrl+f하면 다 바꿀수있음
		ImageIcon ii2=new ImageIcon("E:/dev/workspace/java_se/src/day0125/img4.png");
		ImageIcon ii3=new ImageIcon("E:/dev/workspace/java_se/src/day0125/img2.png");
		ImageIcon ii4=new ImageIcon("E:/dev/workspace/java_se/src/day0125/img3.png");
	
		JLabel jl=new JLabel(ii);
		JButton jbtn=new JButton("지리는 이미지", ii2);
		JButton jbtn2=new JButton("클릭");
		JButton jbtn3=new JButton("차차", ii3);
		
		
		setLayout(null);//수동배치 : 레이아웃 메니저를 날림
		
		jl.setBounds(100,100,300,200);
		jbtn.setBounds(420,100,400,250);
		jbtn2.setBounds(210,160,70,70);
		jbtn3.setBounds(840,100,350,240);
		
		//버튼 제어
		jbtn.setToolTipText("지림");
		jbtn3.setToolTipText("손흔드는 차차");
		//텍스트를 특정 위치로 보내기
		jbtn.setVerticalTextPosition(JButton.BOTTOM);//TOP, CENTER, BOTTOM
		jbtn3.setHorizontalTextPosition(JButton.CENTER);//LEFT, RIGHT, CENTER
		jbtn3.setVerticalTextPosition(JButton.TOP);
		
		//RollOver
		jbtn3.setRolloverIcon(ii4);
		
		//Frame에 컴포넌트를 배치
		add(jbtn2);//먼저 생성해야 마우스 안올려도 잘나옴
		add(jl);
		add(jbtn);//바닥으로 깔림
		add(jbtn3);
		
		setBounds(100,100,1250,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {

		new UseImageIcon();
		
	}

}
