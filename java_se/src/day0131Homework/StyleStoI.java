package day0131Homework;

import java.util.HashMap;
import java.util.Map;

public class StyleStoI {
	
	Map<String, Integer> style;
	
	public StyleStoI () {
		style = new HashMap<String, Integer>();
		for (FontStyle fs: FontStyle.values()) {
			style.put(fs.getName(), fs.getValue());
		}
	}

	public Map<String, Integer> getStyle() {
		return style;
	}
	
}
