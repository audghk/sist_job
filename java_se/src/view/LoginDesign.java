package view;

import java.awt.Font;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import logAnalyze.LogFileParsing;

@SuppressWarnings("serial")
public class LoginDesign extends JFrame {
	private JTextField jtfID;
	private JPasswordField jpfPW;
	private JButton jbtnLogin;
	
	public LoginDesign() {
		super("로그인");
        LoginEvent le = null;

        try {
            le = new LoginEvent(this, new LogFileParsing());
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		jtfID = new JTextField(10);
		jpfPW = new JPasswordField(15);
		jbtnLogin = new JButton("로그인");
		
		JLabel jlID = new JLabel("아이디 ");
		JLabel jlPW = new JLabel("비밀번호 ");
		
		setLayout(null);
		
		jlID.setBounds(20,40,80,30); jtfID.setBounds(100, 40, 150, 30);
		jlPW.setBounds(20,80,80,30); jpfPW.setBounds(100, 80, 150, 30);
		jbtnLogin.setBounds(100,150,80,30);
		
		Font font = new Font("맑은 고딕",Font.BOLD,12);
		
		jlID.setFont(font);
		jlPW.setFont(font);
		jbtnLogin.setFont(font);
		
		add(jlID);
		add(jtfID);
		add(jlPW);
		add(jpfPW);
		add(jbtnLogin);
		
		jbtnLogin.addActionListener(le);
		addWindowListener(le);
		
		setBounds(780,400,300,250);
		setVisible(true);
		setResizable(false);
//		this.getContentPane().setBackground(Color.black);
	}//Test

	public JTextField getJtfID() {
		return jtfID;
	}

	public void setJtfID(JTextField jtfID) {
		this.jtfID = jtfID;
	}

	public JPasswordField getJpfPW() {
		return jpfPW;
	}

	public void setJpfPW(JPasswordField jpfPW) {
		this.jpfPW = jpfPW;
	}

	public JButton getJbtnLogin() {
		return jbtnLogin;
	}

	public void setJbtnLogin(JButton jbtnLogin) {
		this.jbtnLogin = jbtnLogin;
	}
}//class
