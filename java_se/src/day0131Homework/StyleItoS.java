package day0131Homework;

import java.util.HashMap;
import java.util.Map;

public class StyleItoS {
	
	Map<Integer, String> style;
	
	public StyleItoS () {
		style = new HashMap<Integer, String>();
		for (FontStyle fs: FontStyle.values()) {
			style.put(fs.getValue(), fs.getName());
		}
	}

	public Map<Integer, String> getStyle() {
		return style;
	}
	
}
