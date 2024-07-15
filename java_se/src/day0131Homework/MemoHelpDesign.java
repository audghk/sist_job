package day0131Homework;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MemoHelpDesign extends JDialog {
	
	JButton jbtnClose;
	
	public MemoHelpDesign (JavaMemoDesign jmd) {
		super(jmd, "메모장 정보", false);
		
		JTextArea jtaMemoInfo = new JTextArea("Java 메모장 Version1.0\n이 메모장은 SHLP(SuHyun\nPublic License)로서 아무나\n가져다 변환 및 배포\n가능합니다.\n편하게 가져다 사용해주세요");
		jtaMemoInfo.setEditable(false);
		
		jbtnClose = new JButton("닫기");
		JScrollPane jsp = new JScrollPane(jtaMemoInfo);
		JPanel jp = new JPanel();
		jp.add(jbtnClose);
		
		MemoHelpEvent mhe = new MemoHelpEvent(this);
		jbtnClose.addActionListener(mhe);
		addWindowListener(mhe);
		
		add("Center", jsp);
		add("South", jp);
		
		setBounds(jmd.getX() + 20, jmd.getY()+20, 250, 180);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	} // MemoHelpDesign

	public JButton getJbtnClose() {
		return jbtnClose;
	} // getJbtnClose
	
} // class
