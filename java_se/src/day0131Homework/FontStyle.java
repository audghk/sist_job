package day0131Homework;

import java.awt.Font;

/**
 * 글꼴의 스타일에 대한 Enumeration
 */
public enum FontStyle {
	/**
	 * 일반 
	 */
	PLAIN("일반", Font.PLAIN),
	/**
	 * 굵게
	 */
	BOLD("굵게", Font.BOLD),
	/**
	 * 기울임꼴
	 */
	ITALIC("기울임꼴", Font.ITALIC),
	/**
	 * 굵은 기울임꼴
	 */
	BOLD_ITALIC("굵은 기울임꼴", Font.BOLD|Font.ITALIC);
	
	private final String name;
	private final int value;
	
	private FontStyle (String name, int value) {
		this.name = name;
		this.value = value;
	} // FontStyle

	public String getName() {
		return name;
	} // getName

	public int getValue() {
		return value;
	} // getValue

} // enum
