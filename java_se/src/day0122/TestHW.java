package day0122;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestHW {

	public String printDate(int num) {
		Date date = new Date();
		
//		String temp = "";
		switch (num) {
		case 0:
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE", Locale.KOREA);
			return sdf.format(date);	
		case 1:
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE", Locale.UK);
			return sdf.format(date);	
		case 2:
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE", Locale.JAPAN);
			return sdf.format(date);	
		case 3:
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE", Locale.CANADA);
			return sdf.format(date);
		default :
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE", Locale.KOREA);
			return sdf.format(date);
			
		}//switch
		
	}//printDate
	
	
	

	public static void main(String[] args) {
		TestHW hw = new TestHW();
		System.out.println(hw.printDate(3));

	}//main

}
