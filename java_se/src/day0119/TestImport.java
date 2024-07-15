package day0119;

//import java.util.*;//특정 패키지내의 모든 클래스를 import할 때.(권장하지 않음)
import java.util.ArrayList;//ctrl+shift+o 누르면 한번에 import 할 수 있음.
//import java.sql.Date;//패키지가 다르고 클래스명이 같다면 둘 중 하나만 import가능.
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





/**
 * 다른 패키지에 존재하는 클래스를 가져다 사용할 때
 */
public class TestImport {

	public static void main(String[] args) {

		Date d=new Date();
		java.sql.Date d2=null;//util.Date가 아니고 sql.Date로 사용하고 싶다. => full path 사용하면 됨.
		Date d3=null;
		
		List l=new ArrayList();
		List l2=new ArrayList();
		Map m=new HashMap();
		
	}

}
