package day0117;

public abstract class Dog {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//추상 method
	public abstract String dogWork(String behavior, int time);
	
	@Override
	public String toString() {
		return "강아지입니다.ㅇㅅㅇ";
	}

}
