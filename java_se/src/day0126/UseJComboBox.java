package day0126;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseJComboBox extends JFrame {

	public UseJComboBox() {
		super("JComboBox 사용");
		
		//1. Model객체 생성
		DefaultComboBoxModel<String> dcbm=new DefaultComboBoxModel<String>();
		
		//2. Model객체와 has a 관계로 View 객체 생성
		JComboBox<String> jcb=new JComboBox<String>(dcbm);
		
		//데이터 추가
		dcbm.addElement("고한별");
		dcbm.addElement("김도원");
		dcbm.addElement("김동섭");
		dcbm.addElement("김무영");
		dcbm.addElement("김병년");
		dcbm.addElement("김일신");
		dcbm.addElement("김현종");
		
		JPanel jp=new JPanel();
		jp.setBorder(new TitledBorder("MVC 패턴을 도입할 클래스들"));
		jp.add(jcb);
		
		add("North", jp);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	public static void main(String[] args) {

		new UseJComboBox();
		
	}

}
