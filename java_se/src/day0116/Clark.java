package day0116;

/**
 * 사람의 공통 특징은 부모클래스인 Person에 정의되어 있고, 자식 클래스인
 * Clark은 자신의 특별한 기능만 정의
 * 싸움 레벨은 1~10까지 존재
 */
public class Clark extends Person {//superclass를 바꿔서 생성하면 자동으로 extends 생성됨.

	public int power;
	
	/**
	 * 클락의 기본 생성자, 눈 2개, 코 1개, 입 1개인 사람이 태어남.
	 * 클락은 힘이 세다.
	 */
	public Clark() {

		power=10;		
		
	}
	
	/**
	 * 돌의 종류에 따라 힘의 강도가 달라진다.
	 * @param stone 돌의 종류
	 * @return 결과
	 */
	public String power(String stone) {
		
		String result="";
		
		if(stone.equals("다이아몬드")) {
			result="감사합니다. (^^)(__)";
			power=10;
		}else if(stone.equals("크립토나이트")) {
			result="힘빠짐... ~(_-_)~";
			power=0;
		}else {
			result="열받음 ㅡㅡ+";
			power=12;			
		}
		
		return result;
	}
	
	/**
	 * 집에서 밥을 먹는 일에서 집에서 빵을 먹는 일로 Override한 method
	 */
	@Override
	public String eat() {
		return getName() + "가 집에서 빵을 먹는다.";
	}

	@Override
	public String eat(String menu, int price) {
		return getName() + "가 레스토랑에서 메뉴가 " + menu + "인 음식을 " + price + "$ 내고 사먹는다.";
	}

//	@Override
//	public String toString() {
//		return "나는"+getName()+"이다.";
//	}
	
	
}
