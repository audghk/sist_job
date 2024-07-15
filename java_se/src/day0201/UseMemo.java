package day0201;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class UseMemo extends JFrame implements ActionListener {

	private JTextArea jta;
	private JScrollPane jsp;
	
	private JMenuBar jmb;
	private JMenu jmFile;
	private JMenu jmForm;
	private JMenu jmHelp;
	
	private JMenuItem jmiNew;
	private JMenuItem jmiOpen;
	private JMenuItem jmiSave;
	private JMenuItem jmiQuit;
	
	private JMenuItem jmiFont;
	
	private JMenuItem jmiInfo;

	
	public UseMemo() {
		super("메모장");

		// textarea / 스크롤바 생성
		jta = new JTextArea();
		jsp = new JScrollPane(jta);

		add(jsp);
		// 메뉴바 생성
		jmb = new JMenuBar();

		// 메뉴 생성
		jmFile = new JMenu("파일");
		jmForm = new JMenu("서식");
		jmHelp = new JMenu("도움말");

		// 메뉴 아이템 생성
		jmiNew = new JMenuItem("새글");
		jmiOpen = new JMenuItem("열기");
		jmiSave = new JMenuItem("저장");
		jmiQuit = new JMenuItem("종료");

		jmiFont = new JMenuItem("글꼴");

		jmiInfo = new JMenuItem("메모장 정보");

		// 메뉴 아이템을 메뉴 배치
		jmFile.add(jmiNew);
		jmFile.add(jmiOpen);
		jmFile.add(jmiSave);
		jmFile.add(jmiQuit);

		jmForm.add(jmiFont);

		jmHelp.add(jmiInfo);

		// 메뉴를 메뉴바에 배치
		jmb.add(jmFile);
		jmb.add(jmForm);
		jmb.add(jmHelp);

		// 메뉴 아이템을 프레임에 설정
		setJMenuBar(jmb);

		jmiNew.addActionListener(this);
		jmiOpen.addActionListener(this);
		jmiSave.addActionListener(this);
		jmiQuit.addActionListener(this);
		
		jmiFont.addActionListener(this);
		jmiInfo.addActionListener(this);
		
		setSize(800, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource()==jmiNew) {//완
			System.out.println("새글");
			jta.setText("");
		}
		if(ae.getSource()==jmiOpen) {//D
			System.out.println("열기");
			
		}
		if(ae.getSource()==jmiSave) {//D
			System.out.println("저장");
			
		}
		if(ae.getSource()==jmiQuit) {//완
			System.out.println("종료");
			dispose();
		}
		if(ae.getSource()==jmiFont) {//D
			System.out.println("글꼴");
			
		}
		if(ae.getSource()==jmiInfo) {//D
			System.out.println("메모장 정보");
			
		}
		
	}

	public static void main(String[] args) {
		new UseMemo();
	}

}