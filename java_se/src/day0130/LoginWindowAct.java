package day0130;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class LoginWindowAct extends Frame implements ActionListener {

	private JTextField jtfID;
	private JPasswordField jpfPW;
	private JTextArea jlRe;
	
	public LoginWindowAct() {
		
		jtfID=new JTextField(10);
		jpfPW=new JPasswordField(10);
		jlRe=new JTextArea();
		
		jtfID.setBorder(new TitledBorder("아이디"));
		jpfPW.setBorder(new TitledBorder("비밀번호"));
		jlRe.setBorder(new TitledBorder("결과"));
				
		setLayout(new GridLayout(3,1));
		
		add(jtfID);
		add(jpfPW);
		add(jlRe);
		
		
		jtfID.addActionListener(this);//엔터
		jpfPW.addActionListener(this);//엔터
//		addKeyListener(null);
		
		setSize(300, 200);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}					
		});
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String ID=jtfID.getText();
		String PW=String.valueOf(jpfPW.getPassword());
		
		jlRe.setText("");

		if("root".equals(ID) && "1234".equals(PW) ||
				"admin".equals(ID) && "password".equals(PW) ||
				"temp".equals(ID) && "q1w2e3r4".equals(PW)) {
			jlRe.setForeground(Color.BLUE);
			jlRe.append(ID+"님 로그인");
			
		}else {
			jlRe.setForeground(Color.RED);
			jlRe.append("로그인 실패");
		}
		
	}
	
	public static void main(String[] args) {
	
		new LoginWindowAct();
		
	}

}
