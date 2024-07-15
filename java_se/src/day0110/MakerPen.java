package day0110;

/**
 * 마카펜을 대상으로하여 추상화한 후 작성하는 클래스
 * 
 */
public class MakerPen {

	private int cap, body;
	private String color;
	
	/**
	 * 뚜껑 1개, 몸체 1개, 검은색 마카펜을 생성할 때 사용하는 기본 생성자
	 */
	public MakerPen() {//마카펜의 기본 생성자
//		cap=1;
//		body=1;
//		color="검은";
		this(1,1,"검은");
	}
	
	/**
	 * 입력된 값으로 마카펜 객체를 생성하는 인자 있는 생성자. (Overloading 된 생성자)
	 * 
	 * 색은 "검은", "파란", "빨간"만 설정할 수 있다.
	 * 그 외의 색이 입력되면 "검은"색으로 instance variable을 설정.
	 * 
	 * @param cap 뚜껑의 수
	 * @param body 몸체의 수
	 * @param color 색
	 */
	public MakerPen(int cap, int body, String color) {
		this.cap=cap;
		this.body=body;
		//this.color=color;
		setColor(color);//if문 또 안써도됨
	}
	
	/**
	 * 생성된 마카펜 객체 뚜껑의 개수를 설정하는 일.
	 * 마카펜의 뚜껑은 1개만 설정된다.
	 * @param cap 뚜껑의 개수
	 */
	public void setCap(int cap) {
		
		if(cap != 1) {//유효성 검사 //구현비용에 포함안됨. 서비스코드
			cap=1;
		}
		
		this.cap=cap;
	
	}
	
	/**
	 * 생성된 마카펜 객체 뚜껑의 개수를 반환하는 일.
	 * @return 마카펜 객체의 뚜껑 개수
	 */
	public int getCap() {
		return cap;
	}
	
	/**
	 * 생성된 마카펜 객체의 몸체 개수를 설정하는 일.
	 * @param body 설정할 몸체의 수
	 */
	public void setBody(int body) {
		
		if(body != 1) {//유효성 검사 //구현비용에 포함안됨. 서비스코드
			body=1;
		}
		
		this.body=body;
	}

	/**
	 * 생성된 마카펜 객체의 몸체 개수를 반환하는 일.
	 * @return 몸체의 개수
	 */
	public int getBody() {
		return body;
	}
	
	/**
	 * 생성된 마카펜 객체의 색을 설정하는 일
	 * 색은 "검은", "파란", "빨간"만 설정할 수 있다.
	 * 그 외의 색이 입력되면 "검은"색으로 instance variable을 설정.
	 * @param color 설정할 색
	 */
	public void setColor(String color) {
		if(!("검은".equals(color) || "파란".equals(color) || "빨간".equals(color))) {
			color="검은";
		}
		this.color=color;
	}
	
	/**
	 * 생성된 마카펜 객체의 색을 반환하는 일.
	 * @return 설정된 색
	 */
	public String getColor() {
		return color;
	}
	

	
	/**
	 * 마카펜 객체의 칠판에 쓰는 일을 (동사적인 특징) 구현.
	 * @param msg 쓰고 싶은 메세지
	 * @return 쓰는 일
	 */
	public String write(String msg) {
		
		return "\""+ msg + "\"을 " + color + "색으로 칠판에 쓴다";
	}
	
}
