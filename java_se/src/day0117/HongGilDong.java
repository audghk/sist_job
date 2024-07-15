package day0117;

/**
 * 사람의 공통 특징은 부모클래스인 Person에 정의되어 있고, 자식 클래스인
 * HongGilDong은 자신의 특별한 기능만 정의
 * 싸움 레벨은 1~10까지 존재
 */
public class HongGilDong extends Person{

	private int level;
	
	/**
	 * 홍길동의 기본 생성자, 눈 2개, 코 1개, 입 1개인 사람이 태어남.
	 * 홍길동은 싸움을 평민보다 잘한다.
	 */
	public HongGilDong() {
//		super();//ctrl 누르고 클릭하면 가짐
		level=6;
	}
	
	
	/**
	 * 싸움을 하는 일
	 * @param yourLevel 상대방의 레벨
	 * @return 싸움의 결과
	 */
	public String fight(int yourLevel) {
		String result="";
		if(level<yourLevel) {//싸움에서 지는 경우
			result="싸움에서 졌음. o(>.<)o";
			level--;
			if(level<1) {
				level=1;
			}
		}else if(level>yourLevel) {//싸움에서 이기는 경우
			result="이겼음! s('.^)v";
			level++;
			if(level>10) {
				level=10;
			}
		}else {//비기는 경우
			result="비겼음 ㅡ,.ㅡ;;";
		}
		
		
		return result;
	}

	public int getLevel() {
		return level;
	}
	
	/**
	 * 식당에서 화폐단위가 원인일에서 주막에서 화폐단위가 푼으로 변경되도록 Override
	 */
	@Override
	public String eat(String menu, int price) {
		return getName() + "이 주막에서 메뉴가 " + menu + "인 음식을 " + price + "푼 내고 사먹는다.";
	}


	@Override
	public String eat() {
		return getName()+"이 집에서 밥먹는다.";
	}
	
	
	
//	@Override
//	public String toString() {
//		return "나는"+getName()+"이다.";
//	}
	
}
