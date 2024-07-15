package day0125;

public class WorkVO2 {

	private int stNum;
	private String name;
	private int java;
	private int oracle;
	
	public int getStNum() {
		return stNum;
	}
	public void setStNum(int stNum) {
		this.stNum = stNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getOracle() {
		return oracle;
	}
	public void setOracle(int oracle) {
		this.oracle = oracle;
	}
	
	public WorkVO2() {
	}
	
	public WorkVO2(int stNum, String name, int java, int oracle) {
		this.stNum = stNum;
		this.name = name;
		this.java = java;
		this.oracle = oracle;
	}
	
	
}
