package day0119;

public class UseStringBuffer {

	public void useStringBuffer() {
		//1. 객체화
		StringBuffer sb=new StringBuffer("ddfsfsg");
//		System.out.println(sb);//toString method를 override했기때문에 주소가 안나오고 문자열이 출력됨.
		//2. 객체가 제공하는 method사용
		//값을 sb객체가 참조하는 공간에 추가
		sb.append("안녕");
		sb.append(true);
		sb.append(2024);
		//특정 위치에 값 추가
		sb.insert(6, "수원시의 자랑 윤웅찬");
		//특정 범위의 값 삭제 : delete(시작인덱스, 끝인덱스+1)
		sb.delete(11, 14);
		
		sb.delete(0, sb.length());
		
		sb.append("hello");
		System.out.println(sb);
		
		//sb가 참조하는 메모리에는 hello가 들어있는지 비교하는 코드 작성.
		//hello와 같은 true!
//		if("hello".equals(sb)) {//"hello"는 문자열 저장소에 있고 sb는 heap에 있어서 비교안됨.
//			System.out.println("true!");
//		}else {
//			System.out.println("false!");			
//		}
		//toString()을 써서 heap에 있는 sb를 꺼내서 문자열로 바꿔줌!!!!!!!!!
		System.out.println(sb.toString().equals("hello"));
		
		//sb에는 hello가 소문자로 들어가 있다. >> 대문자로 출력
		System.out.println(sb.toString().toUpperCase());
		
	}
	public void useStringBuilder() {//buffer랑 method가 똑같다~!~! 똑같이 사용하면 됨.
		//1. 객체화
		StringBuffer sb=new StringBuffer("ddfsfsg");
//		System.out.println(sb);//toString method를 override했기때문에 주소가 안나오고 문자열이 출력됨.
		//2. 객체가 제공하는 method사용
		//값을 sb객체가 참조하는 공간에 추가
		sb.append("안녕");
		sb.append(true);
		sb.append(2024);
		//특정 위치에 값 추가
		sb.insert(6, "수원시의 자랑 윤웅찬");
		//특정 범위의 값 삭제 : delete(시작인덱스, 끝인덱스+1)
		sb.delete(11, 14);
				
		sb.delete(0, sb.length());
				
		sb.append("hello");
		System.out.println(sb);
	}
	
	public static void main(String[] args) {

		UseStringBuffer usb=new UseStringBuffer();
		System.out.println("-----------------StringBuffer--------------------");
		usb.useStringBuffer();
		System.out.println("-----------------StringBuilder--------------------");
		usb.useStringBuilder();
		
	}

}
