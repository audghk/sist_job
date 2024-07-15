package day0131;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class UseJOptionPane extends JFrame implements ActionListener, WindowListener {

	private JMenuItem jmiInput, jmiMessage, jmiconfirm;

	public UseJOptionPane() {
		super("JOptionPane 사용");

		JMenuBar jmb = new JMenuBar();// 메뉴바 생성
		JMenu jm = new JMenu("사용");// 메뉴 생성

		// 메뉴 아이템 생성
		jmiInput = new JMenuItem("input dialog");
		jmiMessage = new JMenuItem("message dialog");
		jmiconfirm = new JMenuItem("confirm dialog");

		// 메뉴 아이템을 메뉴에 배치
		jm.add(jmiInput);
		jm.add(jmiMessage);
		jm.add(jmiconfirm);

		// 메뉴를 메뉴바에 배치
		jmb.add(jm);

		// 메뉴바에 Frame 설정
		setJMenuBar(jmb);

		// 이벤트 등록
		jmiInput.addActionListener(this);
		jmiMessage.addActionListener(this);
		jmiconfirm.addActionListener(this);

		setSize(400, 400);
		setVisible(true);

		//X버튼이 눌렸을 때 "아무것도 하지 않도록 설정"
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		addWindowListener(this);//윈도 이벤트가 발생하면 현재 클래스 안에서 이벤트 처리
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//종료

	}

	private void useInput() {
		String data=JOptionPane.showInputDialog("이름을 입력해주세요.","홍길동");
		if(data!=null) {
			System.out.println(data);			
		}
	}

	private void useMessage() {
//		JOptionPane.showMessageDialog(this, "오늘은 수요일입니다.");				
//		JOptionPane.showMessageDialog(this, "오늘은 수요일입니다.","오늘의 요일은",JOptionPane.INFORMATION_MESSAGE);				
//		JOptionPane.showMessageDialog(this, "오늘은 수요일입니다.","오늘의 요일은",JOptionPane.QUESTION_MESSAGE);				
//		JOptionPane.showMessageDialog(this, "오늘은 수요일입니다.","오늘의 요일은",JOptionPane.ERROR_MESSAGE);				
		JOptionPane.showMessageDialog(this, "오늘은 수요일입니다.","오늘의 요일은",JOptionPane.WARNING_MESSAGE);				
	}

	private void useConfirm() {

		int flag=JOptionPane.showConfirmDialog(this, "오늘 수업은 여기까지 하겠습니다.");
		System.out.println(flag);//0,1,2가 나옴
		
		switch(flag) {
		case JOptionPane.OK_OPTION:
			JOptionPane.showMessageDialog(this,"감사합니다.");
			break;
		case JOptionPane.NO_OPTION:
			JOptionPane.showMessageDialog(this,"수업계속해요.");
			break;
		case JOptionPane.CANCEL_OPTION:
			JOptionPane.showMessageDialog(this,"아무생각 없음");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == jmiInput) {
//			System.out.println("input");
			useInput();
		}
		if (ae.getSource() == jmiMessage) {
//			System.out.println("message");
			useMessage();
		}
		if (ae.getSource() == jmiconfirm) {
//			System.out.println("confirm");
			useConfirm();
		}

	}
	
	

	public static void main(String[] args) {

		new UseJOptionPane();

	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	/**
	 * Window에 X버튼을 누르면 windowClosing이 호출된다.
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		int flag=JOptionPane.showConfirmDialog(this, "정말 종료하시겠습니까?");
		
		//"예"가 눌려지면 프로그램이 종료되어야 하지만
		//"아니오"나 "취소"가 눌려지면 아무것도 하지않는다.	
		switch(flag) {
		case JOptionPane.OK_OPTION:
			dispose();
		
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(JFrame.ABORT);
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

}
