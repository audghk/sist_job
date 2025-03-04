package day0307;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class LoginDesign extends Frame implements ActionListener {

	private JTextField jtfId;
	private JPasswordField jpwfPW;
	private JLabel jlResult;


	public LoginDesign() {
		super("SQLInjection 연습");

		component();


		jlResult.setForeground(Color.blue);
		jlResult.setText("아이디와 비밀번호를 입력해 주세요.");

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});

	}

	// 프레임 코드
	public void component() {

		jtfId = new JTextField();
		jpwfPW = new JPasswordField();
		jlResult = new JLabel();
		
		jtfId.addActionListener(this);
		jpwfPW.addActionListener(this);

		JScrollPane jsp1 = new JScrollPane(jtfId);
		JScrollPane jsp2 = new JScrollPane(jpwfPW);
		JScrollPane jsp3 = new JScrollPane(jlResult);

		jtfId.setBorder(new TitledBorder("아이디"));
		jpwfPW.setBorder(new TitledBorder("비밀번호"));
		jlResult.setBorder(new TitledBorder("결과"));

		setLayout(null);
		jsp1.setSize(300, 100);
		jsp2.setSize(300, 100);
		jsp3.setSize(300, 100);

		jsp1.setLocation(30, 33);
		jsp2.setLocation(30, 133);
		jsp3.setLocation(30, 233);

		add(jsp1);
		add(jsp2);
		add(jsp3);

		setSize(350, 350);
		setVisible(true);
		setResizable(false);
		setLocation(700, 200);

	}



	@Override
	public void actionPerformed(ActionEvent ae) {
		//아이디에서 엔터가 눌려지든, 비밀번호에서 엔터가 눌려지든 호출된다.
		String id = jtfId.getText().trim(); // trim()을 통해 앞뒤 공백 제거
		String pass = String.valueOf(jpwfPW.getPassword()).trim();
		checkNull(id,pass);
	}//actionPerformed
	
	public void checkNull(String id, String pass) {
		//아이디와 비밀번호를 받아서 입력 값이 존재하는지 판단하는 method
		if(id.isEmpty()) { // 아이디가 없으면 아이디에 커서 이동
			jtfId.requestFocus();
			return;
		}//end if
		
		
		if(pass.isEmpty()) { // 비번이 없으면 비번에 커서 이동
			jpwfPW.requestFocus();
			return;
		}//end if
		
		//아이디와 패스워드가 모두 존재할 때 실행
		try {
			login(id,pass);
			jtfId.setText("");
			jpwfPW.setText("");
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		
	}//checkNull
	
	private String blockInjection(String str) {
		return str.replaceAll("'", "").replaceAll(" ", "");
	}//blockInjection
	
	public void login(String id, String pass) throws SQLException {
		StringBuilder output = new StringBuilder("로그인 실패!!");
		Color color = Color.RED;
		
		//DBMS를 연동하여 로그인 작업을 수행
		LoginDAO lDAO = LoginDAO.getInstance();
		LoginResultVO lrVO = null;
		
//		id = blockInjection(id);
//		pass = blockInjection(pass);
		
		LoginVO lVO = new LoginVO(id,pass);
		
		try {
//			lrVO = lDAO.selectLogin(lVO);
			lrVO = lDAO.selectPreparedLogin(lVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end catch
		
		if(lrVO != null) { // 객체가 존재하면 로그인 성공
			output.delete(0, output.length());
			output.append(lrVO.getName()).append("님 어서오고! (")
			.append(lrVO.getInput_date()).append(")");
			color = Color.BLUE;
		}//end if
		
		//실패 / 송공의 메시지와 색으로 Label을 설정
		jlResult.setText(output.toString());
		jlResult.setForeground(color);
	}//login
	
	
	
	public static void main(String[] args) {
		new LoginDesign();
	}// main
}
