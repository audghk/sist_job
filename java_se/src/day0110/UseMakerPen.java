package day0110;

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
		
//		black.setCap(10); //기본 생성자가 있으면 쓸필요없음
//		black.setBody(10);
//		black.setColor("파란");
		
		System.out.printf("뚜껑의 수 %d개, 몸체의 수 %d개, ", black.getCap(), black.getBody());
		System.out.printf("마카펜의 색 %s색\n", black.getColor());
		
		//클래스가 제공하는 기능 사용.
		String result=black.write("오늘은 눈내리는 화요일!!");
		System.out.println(result);
		
		//파란색 마카펜을 생성하고, 오늘은 맑은 수요일을 칠판에 써보는 코드 작성
		MakerPen blue=new MakerPen(1,1,"파란");//검은색
		//blue.setColor("파란");//파란색 교체
		
		System.out.printf("마카펜의 색 %s색\n", blue.getColor());
		
		result=blue.write("오늘은 맑은 수요일!!");
		System.out.println(result);
		
	}

}
