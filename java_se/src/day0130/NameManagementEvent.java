package day0130;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * 이벤트를 모아 처리하기 위해 작성
 */
public class NameManagementEvent extends WindowAdapter implements ActionListener {

	private NameManagementDesign nmd;
	
	public NameManagementEvent(NameManagementDesign nmd) {
		this.nmd=nmd;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {

		//이벤트 비교
		if(ae.getSource()==nmd.getJbtnAdd()) {
			addName();
		}
		if(ae.getSource()==nmd.getJbtnRemove()) {
			removename();
		}
		
	}

	@Override
	public void windowClosing(WindowEvent we) {
//		if(JOptionPane.showConfirmDialog(nmd, "정말 종료하시겠습니까?")==JOptionPane.OK_OPTION) {
//			nmd.dispose();			
//		}
		nmd.dispose();
	}
	private void addName() {
		JTextField jtfName=nmd.getJtfName();
		//이름을 가져와서
		String name=nmd.getJtfName().getText().trim();
		
		if(!name.isEmpty()) {
			//Model객체에 값을 설정한다.
			nmd.getDlmName().addElement(name);
			jtfName.setText("");
			jtfName.requestFocus();
		}
	}
	
	private void removename() {
		JTextField jtfName=nmd.getJtfName();
		
		//하나만 삭제
//		nmd.getDlmName().removeElement(jtfName.getText().trim());
		
		DefaultListModel<String> dlmName=nmd.getDlmName();
		
		Object[] obj=new Object[dlmName.size()];
		List<String> list=new ArrayList<String>();
		String tempName="";
		for(int i=0; i<dlmName.size(); i++) {
			tempName=dlmName.getElementAt(i);
			//J.T.F의 이름과 같지 않은 이름만 리스트에 추가
			if(!jtfName.getText().equals(dlmName.getElementAt(i))) {
				list.add(tempName);				
			}
		}
	
		dlmName.removeAllElements();//Model의 모든 아이템을 삭제하고
		
		for(String name : list) {//리스트에 저장된 값으로 Model에 추가
			dlmName.addElement(name);
		}
	
	}
	
	

}
