package day0131Homework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MemoHelpEvent extends WindowAdapter implements ActionListener {
	
	MemoHelpDesign mhd;
	
	public MemoHelpEvent (MemoHelpDesign mhd) {
		this.mhd = mhd;
	} // MemoHelpEvent

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == mhd.getJbtnClose()) {	// 닫기 버튼이 눌려지면 다이얼로그 종료
			mhd.dispose();
		} // end if

	} // actionPerformed

	@Override
	public void windowClosing(WindowEvent e) {
		mhd.dispose();
	} // windowClosing

} // class
