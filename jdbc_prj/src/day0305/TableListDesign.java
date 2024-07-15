package day0305;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class TableListDesign extends JFrame {
	
	
	private JButton  addButton, changeButton, deleteButton, endButton;
	private DefaultListModel<String> dlmData;
	private JTextField jtfNum, jtfName, jtfAge, inputDate;
	private DefaultComboBoxModel<String> image;
	private JList<String> jlData;
	private JComboBox<String> jcbImg;

	public TableListDesign() {
		super("TableList");
		setLayout(null);
		
		
///////////////////////////////////////////////////////////////
		jtfNum = new JTextField(11);
		JLabel jlblNum = new JLabel("번호");
		
		jtfNum.setSize(100,25);
		jtfNum.setLocation(100,50);
		
		jlblNum.setSize(50,25);
		jlblNum.setLocation(60,50);
		
		add(jtfNum);
		add(jlblNum);
		
		jtfName = new JTextField(11);
		JLabel jlblName = new JLabel("이름");
		
		jtfName.setSize(100,25);
		jtfName.setLocation(100,85);
		
		jlblName.setSize(50,25);
		jlblName.setLocation(60,85);
		
		
		add(jtfName);
		add(jlblName);
		
		jtfAge = new JTextField(11);
		JLabel jlblAge = new JLabel("나이");
		
		jtfAge.setSize(100,25);
		jtfAge.setLocation(100,160);
		
		jlblAge.setSize(50,25);
		jlblAge.setLocation(60,160);
		
		add(jlblAge);
		add(jtfAge);

		inputDate = new JTextField(11);
		JLabel jlblDate = new JLabel("입력일");
		
		inputDate.setSize(100,25);
		inputDate.setLocation(100,200);
		
		jlblDate.setSize(50,25);
		jlblDate.setLocation(56,200);
		
		add(jlblDate);
		add(inputDate);
		
///////////////////////////////////////////////////////////////
		
		image = new DefaultComboBoxModel<String>();
		jcbImg = new JComboBox<String>( image );
		JLabel jlblImg = new JLabel("이미지");
		
		image.addElement("img1.png");
		image.addElement("img2.png");
		image.addElement("img3.png");
		image.addElement("img4.png");
		jcbImg.setSize(100,25);
		jcbImg.setLocation(100,120);
		
		jlblImg.setSize(50,25);
		jlblImg.setLocation(56,120);
		
		add(jcbImg);
		add(jlblImg);

	//////////////////////////////J.C.B
		dlmData = new DefaultListModel<String>();
		jlData = new JList<String>(dlmData);
		JScrollPane jspJlData = new JScrollPane(jlData);
		
//		jspJlData.setBorder(new TitledBorder("정보"));
		jspJlData.setSize(250,200);
		jspJlData.setLocation(215,50);
		add(jspJlData);
		
//////////////////////////////////////////////////////////////////////////////
		
		ImageIcon ii=new ImageIcon("C:/dev/workspace/jdbc_prj/src/day0305/img1.png");
//		ImageIcon ii2=new ImageIcon("C:/dev/workspace/jdbc_prj/src/day0305/img4.png");
//		ImageIcon ii3=new ImageIcon("C:/dev/workspace/jdbc_prj/src/day0305/img2.png");
//		ImageIcon ii4=new ImageIcon("C:/dev/workspace/jdbc_prj/src/day0305/img3.png");
	
		JLabel jl=new JLabel(ii);

		setLayout(null);//수동배치 : 레이아웃 메니저를 날림
		jl.setBounds(480,50,150,150);
		add(jl);

/////////////////////////////////////////////////////////////////////////////
		
		addButton = new JButton("추가");
		changeButton = new JButton("변경");
		deleteButton = new JButton("삭제");
		endButton = new JButton("종료");
		
		addButton.setSize(60,25);
		changeButton.setSize(60,25);
		deleteButton.setSize(60,25);
		endButton.setSize(60,25);
		
		addButton.setLocation(180, 300);
		changeButton.setLocation(260, 300);
		deleteButton.setLocation(340, 300);
		endButton.setLocation(420, 300);
		
		add(addButton);
		add(changeButton);
		add(deleteButton);
		add(endButton);
	/////////////////////////////////////////
					
		/////이벤트 등록//////
		TableListEvent tle = new TableListEvent(this);
		addWindowListener(tle);
		addButton.addActionListener(tle);
		changeButton.addActionListener(tle);
		deleteButton.addActionListener(tle);
		endButton.addActionListener(tle);
		jlData.addMouseListener(tle);

		setSize(700,400);		
		setResizable(false);//크기 변경 막기
		setLocation(900, 200);
		setVisible(true);
		
	///////////////////////////
		
	}


	public DefaultComboBoxModel<String> getAge() {
		return image;
	}


	public JButton getAddButon() {
		return addButton;
	}


	public JButton getChangeButon() {
		return changeButton;
	}


	public JButton getDeleteButon() {
		return deleteButton;
	}


	public JButton getEndButon() {
		return endButton;
	}

	public DefaultListModel<String> getDlmData() {
		return dlmData;
	}


	public JTextField getJtfName() {
		return jtfName;
	}


	public JTextField getJftCallNum() {
		return inputDate;
	}


	public JList<String> getJlData() {
		return jlData;
	}


	public JComboBox<String> getJcbAge() {
		return jcbImg;
	}


	
	
	

}

