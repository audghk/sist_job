package view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import logAnalyze.LogFileParsing;

@SuppressWarnings("serial")
public class ViewDesign extends JDialog {
	private JTextField jtfStart;
	private JTextField jtfLast;
	private JButton jbtnResult;
	private JTextArea jtaResult;

    public ViewDesign(SelectDesign sd, LogFileParsing logFileParsing) {
		super(sd,"데이터 분석 프로그램",true);
        ViewEvent ve = new ViewEvent(this, logFileParsing);
		
		jtfStart = new JTextField();
		jtfLast = new JTextField();
		jbtnResult = new JButton("출력");
		jtaResult = new JTextArea("출력 결과");
		JLabel jlResult = new JLabel("결과");
		JLabel jlStart = new JLabel("시작라인");
		JLabel jlLast = new JLabel("끝 라인");
		JScrollPane jsp = new JScrollPane(jtaResult);
		
		jlStart.setBounds(40, 450,150, 20);
		jtfStart.setBounds(100,450,150, 20);
		jlLast.setBounds(300,450,150, 20);
		jtfLast.setBounds(360,450,150, 20);
		jbtnResult.setBounds(600,450,120,20);
		
		jtaResult.setEnabled(false);
		
		Font font = new Font("맑은 고딕",Font.BOLD,12);
		jbtnResult.setFont(font);
		jlResult.setFont(font);
		
		jlResult.setBounds(40,20,60,40);
		jsp.setBounds(40,60, 700, 350);
		
		addWindowListener(ve);
		jbtnResult.addActionListener(ve);
		
		setLayout(null);
		
		add(jlResult);
		add(jsp);
		add(jlStart);
		add(jtfStart);
		add(jlLast);
		add(jtfLast);
		add(jbtnResult);
		
		setBounds(sd.getX()-220,sd.getY()-80,800,550);
		setResizable(false);
		setVisible(true);
	}//ViewDesign

	public JTextField getJtfStart() {
		return jtfStart;
	}

	public void setJtfStart(JTextField jtfStart) {
		this.jtfStart = jtfStart;
	}

	public JTextField getJtfLast() {
		return jtfLast;
	}

	public void setJtfLast(JTextField jtfLast) {
		this.jtfLast = jtfLast;
	}

	public JButton getJbtnResult() {
		return jbtnResult;
	}

	public void setJbtnResult(JButton jbtnResult) {
		this.jbtnResult = jbtnResult;
	}

    public JTextArea getJtaResult() {
        return jtaResult;
    }
}
