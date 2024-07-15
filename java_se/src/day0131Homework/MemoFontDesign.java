package day0131Homework;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Font;

import static java.lang.String.valueOf;


@SuppressWarnings("serial")
public class MemoFontDesign extends JDialog {
	
	@SuppressWarnings("unused")
	private JavaMemoDesign jmd;
	
	private JTextArea jtaNote;
	private JLabel jlblPreview;
	private JTextField jtfFont, jtfStyle, jtfSize;
	private JList<String> jlFont, jlStyle, jlSize;
	private DefaultListModel<String> dlmFont, dlmStyle, dlmSize;
	private JButton jbtnCheck, jbtnCancel;
	
	public MemoFontDesign (JavaMemoDesign jmd) {
		super(jmd, "글꼴", true);
		this.jmd = jmd;
		
		// 컴포넌트 생성 ////////////////////////////////////
		jtaNote = jmd.getJtaNote();
		
		JLabel jlblFont = new JLabel("글꼴(F):");
		JLabel jlblStyle = new JLabel("글꼴 스타일(Y):");
		JLabel jlblSize = new JLabel("크기(S):");
		
		jtfFont = new JTextField();
		jtfStyle = new JTextField();
		jtfSize = new JTextField();
		
		dlmFont = new DefaultListModel<String>();
		dlmStyle = new DefaultListModel<String>();
		dlmSize= new DefaultListModel<String>();
		jlFont = new JList<String>(dlmFont);
		jlStyle = new JList<String>(dlmStyle);
		jlSize = new JList<String>(dlmSize);
		JScrollPane jspFont = new JScrollPane(jlFont);
		JScrollPane jspStyle = new JScrollPane(jlStyle);
		JScrollPane jspSize = new JScrollPane(jlSize);
		
		jlblPreview = new JLabel("");
		jlblPreview.setBorder(new TitledBorder("보기"));
		JScrollPane jspPreview = new JScrollPane(jlblPreview);
		
		jbtnCheck = new JButton("확인");
		jbtnCancel = new JButton("취소");
		
		
		// 컴포넌트 초기값 설정 /////////////////////////////
		jtfFont.setEditable(false);
		jtfStyle.setEditable(false);
		jtfSize.setEditable(false);
		
		// 폰트명 추가
		for(FontName name: FontName.values()) {
			dlmFont.addElement(name.getName());
		} // for
		
		// 폰트 스타일 추가
		for(FontStyle style : FontStyle.values()) {
			dlmStyle.addElement(style.getName());
		} // for

		// 폰트 사이즈 추가
		int size = 8;	// 폰트 크기는 8, 9, 10, 12, 14, 16, 18, ... 78, 80
		do {
			dlmSize.addElement(valueOf(size));
			switch(size) {
			case 8:
			case 9:
				size++;
				break;
			default:
				size += 2;
			} // switch
		} while(size < 81);
		
		// 현재 메모장 JTA에 설정된 폰트를 가져옴
		Font font = jtaNote.getFont();
		
		// 가져온 폰트를 JList에 설정
		jlFont.setSelectedValue(font.getName(), false);
		jtfFont.setText(font.getName());
		for (FontStyle style : FontStyle.values()) {
			if(style.getValue() == font.getStyle()) {
				jlStyle.setSelectedValue(style.getName(), false);
				jtfStyle.setText(style.getName());
				break;
			} // end if
		} // for
		
		jlSize.setSelectedValue(valueOf(font.getSize()), false);
		jtfSize.setText(valueOf(font.getSize()));
		jlSize.ensureIndexIsVisible(jlSize.getSelectedIndex());	// 선택된 위치로 스크롤
		
		jlblPreview.setFont(font);
		jlblPreview.setText("AaBbYyZz");
		
		
		// 컴포넌트 크기 위치 설정 /////////////////////////////
		setLayout(null);
		
		jlblFont.setBounds(20, 10, 220, 30);
		jlblStyle.setBounds(250, 10, 170, 30);
		jlblSize.setBounds(430, 10, 80, 30);
		
		jtfFont.setBounds(20, 40, 220, 30);
		jtfStyle.setBounds(250, 40, 170, 30);
		jtfSize.setBounds(430, 40, 80, 30);
		
		jspFont.setBounds(20, 70, 220, 180);
		jspStyle.setBounds(250, 70, 170, 180);
		jspSize.setBounds(430, 70, 80, 180);
		
		jspPreview.setBounds(250, 260, 261, 120);
		
		jbtnCheck.setBounds(340, 390, 80, 30);
		jbtnCancel.setBounds(430, 390, 80, 30);
		
		
		// 컴포넌트 배치 /////////////////////////////////////
		add(jlblFont);
		add(jlblStyle);
		add(jlblSize);
		
		add(jtfFont);
		add(jtfStyle);
		add(jtfSize);
		
		add(jspFont);
		add(jspStyle);
		add(jspSize);
		
		add(jspPreview);
		
		add(jbtnCheck);
		add(jbtnCancel);
		
		
		// 이벤트 리스너 설정 //////////////////////////////////
		MemoFontEvent mfe = new MemoFontEvent(this);
		jlFont.addMouseListener(mfe);
		jlStyle.addMouseListener(mfe);
		jlSize.addMouseListener(mfe);
		jbtnCheck.addActionListener(mfe);
		jbtnCancel.addActionListener(mfe);
		addWindowListener(mfe);
		
		
		// 다이얼로그 설정 및 사용자에게 보여주기 /////////////// 
		setBounds(jmd.getX() + 40, jmd.getY() + 50, 540, 470);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	} // MemoFontDesign

	public JLabel getJlblPreview() {
		return jlblPreview;
	}

	public JList<String> getJlFont() {
		return jlFont;
	}

	public JList<String> getJlStyle() {
		return jlStyle;
	}

	public JList<String> getJlSize() {
		return jlSize;
	}

	public DefaultListModel<String> getDlmFont() {
		return dlmFont;
	}

	public DefaultListModel<String> getDlmStyle() {
		return dlmStyle;
	}

	public DefaultListModel<String> getDlmSize() {
		return dlmSize;
	}

	public JButton getJbtnCheck() {
		return jbtnCheck;
	}

	public JButton getJbtnCancel() {
		return jbtnCancel;
	}

	public JTextField getJtfFont() {
		return jtfFont;
	}

	public JTextField getJtfStyle() {
		return jtfStyle;
	}

	public JTextField getJtfSize() {
		return jtfSize;
	}

	public JTextArea getJtaNote() {
		return jtaNote;
	}

} // class
