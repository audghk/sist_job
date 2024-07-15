package day0109;

/**
 * MakerPen 클래스에 제공하는 기능(일) 사용하기 위한 클래스
 */
public class UseMakerPen {

	public static void main(String[] args) {

		//마카펜 클래스를 객체화
		MakerPen black=new MakerPen();
		
		System.out.println("주소 : " + black);//주소(heap)
		
		//변수에 값을 직접 할당 => 입력 값을 체크하는 코드를 중복해서 만들어야한다.
//		black.cap=1;
//		if(black.cap != 1) {
//			black.cap=1;
//		}
		
		black.setCap(10);
		black.setBody(10);
		black.setColor("파란");
		
		System.out.printf("뚜껑의 수 %d개, 몸체의 수 %d개, ", black.getCap(), black.getBody());
		System.out.printf("마카펜의 색 %s색\n", black.getColor());
		
		//클래스가 제공하는 기능 사용.
		String result=black.write("오늘은 눈내리는 화요일!!");
		System.out.println(result);
		
	}

}
