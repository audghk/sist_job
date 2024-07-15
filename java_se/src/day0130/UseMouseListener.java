package day0130;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class UseMouseListener extends JFrame implements ListSelectionListener {

	//이벤트와 관련 있는 컴포넌트를 인스턴스 변수에 선언
	private DefaultListModel<String> dlmFriend;
	private DefaultListModel<String> dlmBlockFriend;
	
	private JList<String> jlFriend;
	private JList<String> jlBlockFriend;
	
	private JButton jbtnBlockAll;
	
	public UseMouseListener() {
		super("친구리스트");
		//MVC 패턴이 도입된 컴포넌트는 Model에 값을 설정한다.
		dlmFriend=new DefaultListModel<String>();
		dlmFriend.addElement("루피");
		dlmFriend.addElement("나루토");
		dlmFriend.addElement("이치고");
		dlmFriend.addElement("쵸파");
		dlmFriend.addElement("히루루크");
		
		dlmBlockFriend=new DefaultListModel<String>();
		
		//모델객체와 has a 관계로 View객체를 생성
		jlFriend=new JList<String>(dlmFriend);
		jlBlockFriend=new JList<String>(dlmBlockFriend);
		
		jbtnBlockAll=new JButton(">>");
		
		JScrollPane jspFriend=new JScrollPane(jlFriend);
		JScrollPane jspBlockFriend=new JScrollPane(jlBlockFriend);
		
		jspFriend.setBorder(new TitledBorder("친구"));
		jspBlockFriend.setBorder(new TitledBorder("차단된 친구"));
		
		//이벤트에 컴포넌트를 등록
		jlFriend.addListSelectionListener(this);
		setLayout(null);
		
		jspFriend.setBounds(20, 40, 150, 200);
		jbtnBlockAll.setBounds(190, 130, 50, 30);
		jspBlockFriend.setBounds(250, 40, 150, 200);
	
		add(jspFriend);
		add(jbtnBlockAll);
		add(jspBlockFriend);
		
		setBounds(100,100,430,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println(dlmFriend.getElementAt(jlFriend.getSelectedIndex()));
	}
	
	public static void main(String[] args) {
		
		new UseMouseListener();
		
	}

}
