package day0131Homework;

/**
 * 글꼴의 이름에 대한 enumeration
 */
public enum FontName {
	/**
	 * 고딕체 
	 */
	GOTHIC("고딕체"),
	/**
	 * 궁서체
	 */
	GUNGSEO("궁서체"),
	/**
	 * Consolas
	 */
	CONSOLAS("Consolas"),
	/**
	 * 새굴림
	 */
	NEW_GULIM("새굴림"),
	/**
	 * 맑은 고딕
	 */
	CLEAR_GOTHIC("맑은 고딕");
	
	private final String name;
	
	private FontName(String name) {
		this.name = name;
	} // FontName

	public String getName() {
		return name;
	} // getName
} // enum
