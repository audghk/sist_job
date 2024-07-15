package day0131;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 부가적인 기능을 제공하기 위해 제작하는 창 : Dialog
 */
@SuppressWarnings("serial")
public class SubJDialog extends JDialog implements ActionListener {
	
	public SubJDialog(ParentFrame pf) {//Frame의 자식창
//		super(pf,"부가적인 기능",true);//modal
		super(pf,"부가적인 기능",false);//non-modal
		
		ImageIcon ii=new ImageIcon("E:/dev/workspace/java_se/src/day0125/img3.png");
		JLabel jlblBack=new JLabel("자식창에서 제공하는 이미지", ii, JLabel.CENTER);
		
		JButton jbtn=new JButton("닫기");
		JPanel jp=new JPanel();
		jp.add(jbtn);
		
		add("Center",jlblBack);
		add("South",jp);
		
		//JDialog는 이벤트 등록 코드를 setVisible 전에 정의해야한다.
		jbtn.addActionListener(this);

		//JDialog를 부모의 창 안에 띄우기!
		setBounds(pf.getX()+100,pf.getY()+150,244,200);
		
//		setSize(244,200);
//		setLocation(pf.getLocation());
//		setBounds(100,100,244,200);
		setVisible(true);//사용자에게 보여지는 일
		
		//JDialog의 종료 : DISPOSE_ON_CLOSE사용
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	
		
	}//SubJDialog

	@Override
	public void actionPerformed(ActionEvent e) {

		dispose();
		//System.exit(JFrame.ABORT);//사용하지 않는다. 마지막 프로그램에서만 사용하기~!~!
	}

}
