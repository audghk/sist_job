package day0131;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ParentFrame extends JFrame implements ActionListener {

	private JButton jbtn,jbtnOpen,jbtnSave;
	
	public ParentFrame() {
	
		super("다이얼로그 연습");
		
		jbtn=new JButton("다이얼로그");
		jbtnOpen=new JButton("파일다이얼로그 열기");
		jbtnSave=new JButton("파일다이얼로그 저장");
				
		JPanel jp=new JPanel();
		jp.add(jbtn);
		jp.add(jbtnOpen);
		jp.add(jbtnSave);
		
		jbtn.addActionListener(this);
		jbtnOpen.addActionListener(this);
		jbtnSave.addActionListener(this);
		
		add("Center",jp);
		setBounds(200,200,500, 500);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==jbtn) {
			new SubJDialog(this);			
		}
		if(ae.getSource()==jbtnOpen) {
			open();
		}
		if(ae.getSource()==jbtnSave) {
			save();
		}
		
	}
	
	public void open() {
		FileDialog fdOpen=new FileDialog(this,"파일열기",FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String path=fdOpen.getDirectory();
		String fName=fdOpen.getFile();
//		System.out.println(path+fName);
		
		if(path!=null) {//취소를 누르면 경로나 파일명에 null 입력
			if(path.length()>10) {
//				System.out.println(path.substring(path.indexOf(5)+1)+"...");
				path=path.substring(0,10)+"...";
			}
		}
	
		setTitle(path+fName);
		
		
	}
	
	public void save() {
		FileDialog fdSave=new FileDialog(this,"파일저장",FileDialog.SAVE);
		fdSave.setVisible(true);
		
		String path=fdSave.getDirectory();
		String fName=fdSave.getFile();
//		System.out.println(path+fName);
		
		if(path!=null) {//취소를 누르면 경로나 파일명에 null 입력
			if(path.length()>10) {
//				System.out.println(path.substring(path.indexOf(5)+1)+"...");
				path=path.substring(0,10)+"...";
			}
		}
	
		setTitle("저장 "+path+fName);
	}
	

	
	
	
	public static void main(String[] args) {

		new ParentFrame();
//		JOptionPane.showInputDialog("입력","기본값"); //사용자가 입력하는 값을 받기 위한 Dialog
//		JOptionPane.showMessageDialog(null, "메시지"); //
//		JOptionPane.showConfirmDialog(null, "입력");//사용자의 의향을 물어볼 수 있는 Dialog
		
		
	}

}
