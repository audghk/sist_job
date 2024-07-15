package day0131Homework;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static java.lang.Integer.parseInt;

public class MemoFontEvent extends WindowAdapter implements ActionListener, MouseListener {
	
	private MemoFontDesign mfd;
	
	private JTextArea jtaNote;
	private JLabel jlblPreview;
	private JTextField jtfFont, jtfStyle, jtfSize;
	private JList<String> jlFont, jlStyle, jlSize;
	private DefaultListModel<String> dlmFont, dlmStyle, dlmSize;
	private JButton jbtnCheck, jbtnCancel;
	
	public MemoFontEvent(MemoFontDesign mfd) {
		this.mfd = mfd;
		
		jtaNote = mfd.getJtaNote();
		jlblPreview = mfd.getJlblPreview();
		jtfFont = mfd.getJtfFont();
		jtfStyle = mfd.getJtfStyle();
		jtfSize = mfd.getJtfSize();
		jlFont = mfd.getJlFont();
		jlStyle = mfd.getJlStyle();
		jlSize = mfd.getJlSize();
		dlmFont = mfd.getDlmFont();
		dlmStyle = mfd.getDlmStyle();
		dlmSize = mfd.getDlmSize();
		jbtnCheck = mfd.getJbtnCheck();
		jbtnCancel = mfd.getJbtnCancel();
	} // MemoFontEvent
	
	/**
	 * 선택된 폰트 스타일의 텍스트와 매칭되는 정수값을 반환하는 일을 하는 method
	 * @return 폰트 스타일 (int)
	 */
	private int getSelectedStyle() {
		int intStyle = 0;
		String strStyle = dlmStyle.getElementAt(jlStyle.getSelectedIndex());
		
		for (FontStyle style : FontStyle.values()) {
			if(strStyle.equals(style.getName())) {
				intStyle = style.getValue();
				break;
			} // if
		} // for
		
		return intStyle;
	} // getSelectedStyle
	
	/**
	 * 선택된 JList의 인덱스가 가리키는 DLM의 값들을 조합하여 폰트를 생성하고
	 * 이를 미리보기로 보여주는 일을 하는 method 
	 */
	private void setPreview() {
		String strFont = dlmFont.getElementAt(jlFont.getSelectedIndex());
		String strStyle = dlmStyle.getElementAt(jlStyle.getSelectedIndex());
		int intStyle = getSelectedStyle();
		String strSize = dlmSize.getElementAt(jlSize.getSelectedIndex());
		Font font = new Font(strFont, intStyle, parseInt(strSize));
		
		jtfFont.setText(strFont);
		jtfStyle.setText(strStyle);
		jtfSize.setText(strSize);
		
		jlblPreview.setFont(font);
		
	} // setPreview
	
	/**
	 * 선택된 JList의 인덱스가 가리키는 DLM의 값들을 조합하여 폰트를 생성하고
	 * 이를 JTA 메모장에 설정하는 일을 하는 method
	 */
	private void applyFont() {
		int intStyle = getSelectedStyle();
		Font font = new Font(dlmFont.getElementAt(jlFont.getSelectedIndex()),
				intStyle,
				parseInt(dlmSize.getElementAt(jlSize.getSelectedIndex())));
		jtaNote.setFont(font);
		mfd.dispose();
	} // applyFont
	
	/**
	 * 다이얼로그를 종료하는 일을 하는 method
	 */
	private void closeFontDialog() {
		mfd.dispose();
	} // closeFontDialog

	@Override
	public void windowClosing(WindowEvent e) {
		closeFontDialog();
	} // windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jbtnCheck) {	// 확인 버튼이 눌리면
			applyFont();		// 폰트를 적용
		} // end if
		if(ae.getSource() == jbtnCancel) {	// 취소 버튼이 눌리면
			closeFontDialog();	// 다이얼로그 닫기
		} // end if
	} // actionPerformed
	
	@Override
	public void mousePressed(MouseEvent me) {
		// 폰트에 관한 세 리스트가 눌렸을 때
		if(me.getSource() == jlFont || me.getSource() == jlStyle || me.getSource() == jlSize) {
			setPreview();	// 미리보기를 갱신
		} // end if
	} // mousePressed

	
	
	
	
	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

} // class
