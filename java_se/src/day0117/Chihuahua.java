package day0117;

public class Chihuahua extends Dog{
	
	@Override
	public String dogWork(String behavior, int time) {
		return getName() + "가 " + behavior +"를 " + time + "시간동안 부린다.";
	}
	
	
}
