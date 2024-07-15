package day0131Homework;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class JavaMemoEvent extends WindowAdapter implements ActionListener {
	
	private JavaMemoDesign jmd;
	private JMenuItem jmiNew, jmiOpen, jmiSave, jmiClose, jmiFont, jmiHelp;
	private JTextArea jtaNote;
	
	public JavaMemoEvent(JavaMemoDesign jmd) {
		this.jmd = jmd;
		
		this.jmiNew = jmd.getJmiNew();
		this.jmiOpen = jmd.getJmiOpen();
		this.jmiSave = jmd.getJmiSave();
		this.jmiClose = jmd.getJmiClose();
		this.jmiFont = jmd.getJmiFont();
		this.jmiHelp = jmd.getJmiHelp();
		this.jtaNote = jmd.getJtaNote();
	} // JavaMemoEvent

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jmiNew) {	// 새글
			newMemo();
		} // end if
		if(ae.getSource() == jmiOpen) {	// 열기
			openMemo();
		} // end if
		if(ae.getSource() == jmiSave) {	// 저장
			saveMemo();
		} // end if
		if(ae.getSource() == jmiClose) {// 종료
			closeMemo();
		} // end if
		if(ae.getSource() == jmiFont) {	// 글꼴
			fontDialog();
		} // end if
		if(ae.getSource() == jmiHelp) {	// 메모장 정보
			helpDialog();
		} // end if
	} // actionPerformed
	
	@Override
	public void windowClosing(WindowEvent e) {
		jmd.dispose();
	} // windowClosing
	
	/**
	 * 새글
	 * JTA를 초기화한다
	 */
	private void newMemo() {
//		int flag=0;
//		if(jtaNote!=null) {
//			flag=JOptionPane.showConfirmDialog(null, "저장하시겠습니까?");
//		}else {
			jtaNote.setText("");
//		}
	} // newMemo
	
	/**
	 * 열기
	 * FileDialog를 “열기모드”로 생성하고
	  선택한 파일의 “경로와 파일명”을 열기을 앞에 붙여
	   “타이틀 바”에 설정한다.  => 열기 경로/파일명
	 */
	private void openMemo() {
		FileDialog fdOpen = new FileDialog(jmd, "열기", FileDialog.LOAD);
		fdOpen.setVisible(true);
		String path = fdOpen.getDirectory();
		String fName = fdOpen.getFile();
		if(path == null) {
			return;
		} // end if
		if(path.length() > 10) {
			path = path.substring(0, 10).concat("...");
		}
		jmd.setTitle("열기 ".concat(path).concat(fName));
	} // openMemo
	
	/**
	 * 저장
	 * FileDialog를 “저장모드”로 생성하고
	  선택한 파일의 “경로와 파일명”을 저장을 앞에 붙여 
	  “타이틀 바”에 설정한다. =>저장 경로/파일명
	 */
	private void saveMemo() {
		FileDialog fdSave = new FileDialog(jmd, "저장", FileDialog.SAVE);
		fdSave.setVisible(true);
		String path = fdSave.getDirectory();
		String fName = fdSave.getFile();
		if(path == null) {
			return;
		} // end if
		if(path.length() > 10) {
			path = path.substring(0, 10).concat("...");
		} // end if
		jmd.setTitle("저장 ".concat(path).concat(fName));
		
	} // saveMemo    
	
	/**
	 * 종료
	 * 메모장을 종료한다 
	 */
	private void closeMemo() {
		jmd.dispose();
	} // closeMemo
	
	/**
	 * 글꼴
	 * 다이얼로그를 현재 JTextArea의 
   	글꼴 적용상태로 설정하여 보여준다
	 */
	private void fontDialog() {
		new MemoFontDesign(jmd);
	} // fontDialog
	
	/**
	 * 메모장 정보
 	Dialog를 보여준다.
	 */
	private void helpDialog() {
		new MemoHelpDesign(jmd);
	} // helpDialog

} // class