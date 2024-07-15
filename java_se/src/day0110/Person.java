package day0110;

/**
 * 사람을 추상화하여 구현하는 클래스.
 * 명사적 특징) 눈, 코, 입
 * 동사적 특징) 먹는 일
 * 
 * 객체생성을 하여 사용하는 일반 클래스.
 * 사용법)
 * Person 객체명=new Person();
 * 객체명.method()를 호출하여 사용
 */
public class Person {

	private int eye, nose, mouth;
	private String name;
//	private String nick;
	
	/**
	 * 눈 2개, 코 1개, 입 1개인 사람 객체를 생성할 때 사용하는 기본 생성자.
	 */
	public Person() {
//		eye=2;
//		nose=1;
//		mouth=1;
		this(2,1,1);
		
	}
	
	/**
	 * 눈 n개, 코 n개, 입 n개인 사람 객체를 생성할 때 사용하는 Overloading 생성자
	 * @param eye 눈의 수
	 * @param nose 코의 수
	 * @param mouth 입의 수
	 */
	public Person(int eye, int nose, int mouth) {
		this.eye=eye;
		this.nose=nose;
		this.mouth=mouth;
	}
	
	/**
	 * 생성된 사람객체에 눈의 개수를 설정하는 일
	 * @param eye 눈의 개수
	 */
	public void setEye(int eye) {
		this.eye=eye;
	}
	/**
	 * 생성된 사람객체가 가지고 있는 눈의 개수를 반환하는 일
	 * @return 눈의 수
	 */
	public int getEye() {
		return eye;
	}
	
	/**
	 * 생성된 사람객체에 코의 개수를 설정하는 일
	 * @param nose 설정할 코의 수
	 */
	public void setNose(int nose) {
		this.nose=nose;
	}
	/**
	 * 생성된 사람객체가 가지고 있는 코의 개수를 반환하는 일
	 * @return 코의 수
	 */
	public int getNose() {
		return nose;
	}
	
	/**
	 * 생성된 사람객체에 입의 개수를 설정하는 일
	 * @param mouth 설정할 입의 수
	 */
	public void setMouth(int mouth) {
		this.mouth=mouth;
	}
	/**
	 * 생성된 사람객체가 가지고 있는 입의 개수를 반환하는 일
	 * @return 입의 수
	 */
	public int getMouth() {
		return mouth;
	}
	
	/**
	 * 생성된 사람객체에 이름을 설정하는 일
	 * @param name 설정할 이름
	 */
	public void setName(String name) {
		this.name=name;
	}
	/**
	 * 생성된 사람객체의 이름을 반환하는 일
	 * @return 설정된 이름
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 사람의 동사적인 특징 중 집에서 밥을 먹는 일을 구현한 method.
	 * @return 밥을 먹는 행동
	 */
	public String eat() {
		return name + "이(가) 집에서 밥을 먹는다.";
	}
	/**
	 * 사람의 동사적인 특징 중 식당에서 밥을 사먹는 일을 구현한 method.
	 * @param menu 음식 종류
	 * @param price 음식 가격
	 * @return 밥을 먹는 행동
	 */
	public String eat(String menu, int price) {
		return name + "이 식당에서 메뉴가 " + menu + "인 음식을 " + price + "원 내고 사먹는다.";
	}
	
}
