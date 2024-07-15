package view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import logAnalyze.LogFileParsing;

@SuppressWarnings("serial")
public class SelectDesign extends JFrame {
	private JButton jbtnView; // dialog에 출력
	private JButton jbtnReport; // 파일 생성
	
    public SelectDesign(LogFileParsing logFileParsing, LoginDesign ld) {
		super("메뉴");
        SelectEvent se = new SelectEvent(this, logFileParsing, ld);
		
		JLabel jlResult = new JLabel("수행할 작업을 선택해주세요");
		jbtnView = new JButton("view");
		jbtnReport = new JButton("report");
		
		setLayout(null);
		
		jlResult.setBounds(60,60,160,30);
		jbtnView.setBounds(50, 130, 80, 30);
		jbtnReport.setBounds(150, 130, 80, 30);
		
		Font font = new Font("맑은 고딕",Font.BOLD,12);
		
		jlResult.setFont(font);
		jbtnView.setFont(font);
		jbtnReport.setFont(font);
		
		jbtnView.addActionListener(se);
		jbtnReport.addActionListener(se);
		addWindowListener(se);
		
		add(jlResult);
		add(jbtnView);
		add(jbtnReport);
		
		setBounds(ld.getX(),ld.getY(),300,250);
		setVisible(true);
		setResizable(false);
	}//ViewDesign

	public JButton getJbtnView() {
		return jbtnView;
	}

	public void setJbtnView(JButton jbtnView) {
		this.jbtnView = jbtnView;
	}

	public JButton getJbtnReport() {
		return jbtnReport;
	}

	public void setJbtnReport(JButton jbtnReport) {
		this.jbtnReport = jbtnReport;
	}
}
