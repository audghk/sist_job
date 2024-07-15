package day0129;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
//1. Window Component 상속, 이벤트 처리용 XxxListener 구현
public class UseActionEvent extends JFrame implements ActionListener{

	//3. Override한 method안에서 사용해야할 컴포넌트를 인스턴스 변수로 선언
	private JTextField jtfName;//instance 변수
	private JTextArea jtaList;
	private JComboBox<String> jcbGender;
	
	public UseActionEvent() {
		super("여러 레이아웃 메니저 사용");
		//2. 컴포넌트 생성
		JLabel jlblName=new JLabel("이름");
		jtfName=new JTextField(10);
		
		jcbGender=new JComboBox<String>();
		jcbGender.addItem("남자");
		jcbGender.addItem("여자");
		
		JButton jbtnInput=new JButton("입력");
		

		//바닥이 투명한 컴포넌트는 투명도를 설정해야한다.
		jlblName.setOpaque(true);
		
		jtaList=new JTextArea();
		JScrollPane jsp=new JScrollPane(jtaList);

		//4. 컴포넌트를 이벤트에 등록
		jbtnInput.addActionListener(this);
		jtfName.addActionListener(this);
		
		//여러개의 컴포넌트를 관리하기 위해서 Container Component를 사용.
		JPanel jpNorth=new JPanel();
		jpNorth.add(jlblName);//JPanel에 컴포넌트를 배치
		jpNorth.add(jtfName);//JPanel에 컴포넌트를 배치
		jpNorth.add(jcbGender);//JPanel에 컴포넌트를 배치
		jpNorth.add(jbtnInput);//JPanel에 컴포넌트를 배치
		
		//윈도우 컴포넌트(사용자에게 보여지는)에 배치
		add("North", jpNorth);
		add("Center", jsp);

		
		add("Center",jtaList);
		
		setSize(450,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	//2. XxxListener에 abstract method Override
	@Override
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 발생했을 때 사용자에게 제공할 코드
		//JTextField의 값을 가져와서 JTextArea에 설정한다.
		String data=jtfName.getText();
		
		//Model객체를 사용하지 않았으므로 View객체에서 선택된 아이템의 값을 얻는다.
		String gender=(String)jcbGender.getSelectedItem();
		
//		jtaList.setText(data+"님");
		jtaList.append(gender+" : "+data+"님\n");
		jtfName.setText("");
	}

	
	public static void main(String[] args) {

		new UseActionEvent();
		
	}

}
