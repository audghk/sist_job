package day0131Homework;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class JavaMemoDesign extends JFrame{

	private JMenuItem jmiNew, jmiOpen, jmiSave, jmiClose, jmiFont, jmiHelp;
	private JTextArea jtaNote;
	private Font fontNote;
	
	public JavaMemoDesign() {
		super("메모장");
		
		JMenuBar jmb = new JMenuBar();
		JMenu jmFile = new JMenu("파일");
		JMenu jmForm = new JMenu("서식"); 
		JMenu jmHelp = new JMenu("도움말");
		
		jmiNew = new JMenuItem("새글");
		jmiOpen = new JMenuItem("열기");
		jmiSave = new JMenuItem("저장");
		jmiClose = new JMenuItem("종료");
		jmiFont = new JMenuItem("글꼴");
		jmiHelp = new JMenuItem("메모장 정보");
		
		fontNote = new Font(FontName.CLEAR_GOTHIC.getName(), Font.PLAIN, 10);
		jtaNote = new JTextArea();
		jtaNote.setFont(fontNote);
		
		jmFile.add(jmiNew);
		jmFile.addSeparator();
		jmFile.add(jmiOpen);
		jmFile.add(jmiSave);
		jmFile.addSeparator();
		jmFile.add(jmiClose);
		jmForm.add(jmiFont);
		jmHelp.add(jmiHelp);
		
		jmb.add(jmFile);
		jmb.add(jmForm);
		jmb.add(jmHelp);
		
		JScrollPane jsp = new JScrollPane(jtaNote);
		
		setJMenuBar(jmb);
		
		JavaMemoEvent jme = new JavaMemoEvent(this);
		
		jmiNew.addActionListener(jme);
		jmiOpen.addActionListener(jme);
		jmiSave.addActionListener(jme);
		jmiClose.addActionListener(jme);
		jmiFont.addActionListener(jme);
		jmiHelp.addActionListener(jme);
		addWindowListener(jme);

		setLayout(new BorderLayout());	// default가 BorderLayout()
		
		add("Center", jsp);
		
		setBounds(460, 140, 700, 600);
		setVisible(true);
	} // JavaMemoDesign

	public JMenuItem getJmiNew() {
		return jmiNew;
	}

	public JMenuItem getJmiOpen() {
		return jmiOpen;
	}

	public JMenuItem getJmiSave() {
		return jmiSave;
	}

	public JMenuItem getJmiClose() {
		return jmiClose;
	}

	public JMenuItem getJmiFont() {
		return jmiFont;
	}

	public JMenuItem getJmiHelp() {
		return jmiHelp;
	}

	public JTextArea getJtaNote() {
		return jtaNote;
	}

	public Font getFontNote() {
		return fontNote;
	}

} // class
