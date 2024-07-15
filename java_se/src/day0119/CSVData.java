package day0119;

import java.util.Arrays;

public class CSVData {

	private String[] data;
	
	public CSVData() {
		
	}
	
	public CSVData(String[] data) {
		this.data=data;
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CSVData [data=" + Arrays.toString(data) + "]";
	}
	
	
}
