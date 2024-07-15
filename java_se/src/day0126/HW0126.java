package day0126;

import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.time.LocalDate;


/**
 * 프로그램이 실행되면 현재 월의 달력을 만들어서 아래와 같이 JButton을 사용하여 보여주는 Window Application을 작성
 */
@SuppressWarnings("serial")
public class HW0126 extends JFrame {

	public HW0126() {
		super("달력");
		Calendar cal = Calendar.getInstance();
		
		int[] dayArr= {};
		
		for(int i=0; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			dayArr[i]=cal.get(Calendar.DAY_OF_MONTH);
		}
		
		JButton[] jrbArr=new JButton[dayArr.length];
		setLayout(new GridLayout(5,7));
		
		for(int i=0; i<dayArr.length; i++) {
			//jrbArr[i]=new JButton(dayArr[i]);
			add(jrbArr[i]);
		}
		
		setSize(500,600);	
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


	public static void main(String[] args) {

		new HW0126();
//		HW0126 hw=new HW0126();
//		hw.useCalendar();
		
	}

}
