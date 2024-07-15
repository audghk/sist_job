package day0110;

public class Dog {

	private int lifeLength, leg;
	private String kind;
	
	public Dog() {
		lifeLength=20;
		leg=4;
		kind="포유류";	
	}
	
	public Dog(int lifeLength, int leg, String kind) {
		this.lifeLength=lifeLength;
		setLeg(leg);
		setKind(kind);
	}
	
	public void setLifeLength(int lifeLength) {
		this.lifeLength=lifeLength;
	}
	public int getLifeLength() {
		return lifeLength;
	}
	
	public void setLeg(int leg) {
		this.leg=leg;
	}
	public int getLeg() {
		return leg;
	}
	
	public void setKind(String kind) {
		this.kind=kind;
	}
	public String getKind() {
		return kind;
	}
	
	public String write(String dogKind, String personality) {
		return dogKind +"는 성격이 매우 " + personality + "다.";
	}
	
}
