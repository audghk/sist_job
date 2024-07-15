package day0130;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class UseMouseListener2 extends JFrame implements MouseListener, ActionListener {

	// 이벤트와 관련 있는 컴포넌트를 인스턴스 변수에 선언
	private DefaultListModel<String> dlmFriend;
	private DefaultListModel<String> dlmBlockFriend;

	private JList<String> jlFriend;
	private JList<String> jlBlockFriend;

	private JButton jbtnBlockAll;
	private JButton jbtnBlockAll2;

	public UseMouseListener2() {
		super("친구리스트");
		// MVC 패턴이 도입된 컴포넌트는 Model에 값을 설정한다.
		dlmFriend = new DefaultListModel<String>();
		dlmFriend.addElement("루피");
		dlmFriend.addElement("나루토");
		dlmFriend.addElement("이치고");
		dlmFriend.addElement("쵸파");
		dlmFriend.addElement("히루루크");

		dlmBlockFriend = new DefaultListModel<String>();

		// 모델객체와 has a 관계로 View객체를 생성
		jlFriend = new JList<String>(dlmFriend);
		jlBlockFriend = new JList<String>(dlmBlockFriend);

		jbtnBlockAll = new JButton(">>");
		jbtnBlockAll2 = new JButton("<<");

		JScrollPane jspFriend = new JScrollPane(jlFriend);
		JScrollPane jspBlockFriend = new JScrollPane(jlBlockFriend);

		jspFriend.setBorder(new TitledBorder("친구"));
		jspBlockFriend.setBorder(new TitledBorder("차단된 친구"));

		// 이벤트에 컴포넌트를 등록
		jlFriend.addMouseListener(this);
		jbtnBlockAll.addActionListener(this);
		jlBlockFriend.addMouseListener(this);
		jbtnBlockAll2.addActionListener(this);

		setLayout(null);

		jspFriend.setBounds(20, 40, 150, 200);
		jbtnBlockAll.setBounds(190, 130, 50, 30);
		jbtnBlockAll2.setBounds(190, 180, 50, 30);
		jspBlockFriend.setBounds(250, 40, 150, 200);

		add(jspFriend);
		add(jbtnBlockAll);
		add(jbtnBlockAll2);
		add(jspBlockFriend);

		setBounds(100, 100, 430, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void mouseClicked(MouseEvent me) {
//		System.out.println("clicked");// 키의 작업이 종료된 후
		// 어떤 키가 눌리든 호출된다. : 키에 대한 비교
//		System.out.println(me.getButton());//눌려진 버튼의 값 얻기
//		if(me.getButton()==MouseEvent.BUTTON1) {
//			System.out.println("왼쪽 클릭");
//		}
		switch (me.getButton()) {
		case MouseEvent.BUTTON1:
			if(me.getSource()==jlFriend) {//친구리스트에서 이벤트가 발생
				int idx = jlFriend.getSelectedIndex();
				if (idx != -1) {// 예외처리
					// 선택된 인덱스에 해당하는 값을 Model에서 얻고
//					String name=dlmFriend.getElementAt(jlFriend.getSelectedIndex());
					String name = dlmFriend.getElementAt(idx);
					// 얻어낸 값을 차단된 친구로 등록(dlmBlockFriend)
					dlmBlockFriend.addElement(name);
					System.out.println(name);
					// 선택된 인덱스에 해당하는 값을 Model에서 삭제
					dlmFriend.remove(idx);
				}
			}
			if(me.getSource()==jlBlockFriend) {//차단친구리스트에서 이벤트가 발생
				int idx = jlBlockFriend.getSelectedIndex();
				if (idx != -1) {// 예외처리
					// 선택된 인덱스에 해당하는 값을 Model에서 얻고
//					String name=dlmFriend.getElementAt(jlFriend.getSelectedIndex());
					String name = dlmBlockFriend.getElementAt(idx);
					// 얻어낸 값을 차단된 친구로 등록(dlmBlockFriend)
					dlmFriend.addElement(name);
					System.out.println(name);
					// 선택된 인덱스에 해당하는 값을 Model에서 삭제
					dlmBlockFriend.remove(idx);
				}
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
//		System.out.println("pressed");//처음 클릭 되었을 때

	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		System.out.println("released");//클릭된 키가 올라왔을 때

	}

	@Override
	public void mouseEntered(MouseEvent e) {
//		System.out.println("Entered");

	}

	@Override
	public void mouseExited(MouseEvent e) {
//		System.out.println("exited");

	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == jbtnBlockAll) {
			// 친구 리스트에서 모든 값을 가져와서
			Object[] obj = new Object[dlmFriend.size()];// 배열 생성
			obj = dlmFriend.toArray();// 친구리스트의 모든 값을 배열로 복사
			// 차단된 친구리스트에 넣고
			for (int i = 0; i < obj.length; i++) {
				dlmBlockFriend.addElement(obj[i].toString());
			}
			// 삭제
			dlmFriend.removeAllElements();
		}

		if (ae.getSource() == jbtnBlockAll2) {
			// 차단친구 리스트에서 모든 값을 가져와서
			Object[] obj2 = new Object[dlmBlockFriend.size()];// 배열 생성
			obj2 = dlmBlockFriend.toArray();// 차단 친구리스트의 모든 값을 배열로 복사
			// 친구리스트에 넣고
			for (int i = 0; i < obj2.length; i++) {
				dlmFriend.addElement(obj2[i].toString());
			}
			// 삭제
			dlmBlockFriend.removeAllElements();
		}

	}

	public static void main(String[] args) {

		new UseMouseListener2();

	}

}
