package day0119;

import java.util.Arrays;

public class TokenDataVO {

	private String[] data;
	private int countToken;
	
	public TokenDataVO() {
		
	}
	
	
	public TokenDataVO(String[] data, int countToken) {
		this.data=data;
		this.countToken=countToken;
	}


	public String[] getData() {
		return data;
	}


	public void setData(String[] data) {
		this.data = data;
	}


	public int getCountToken() {
		return countToken;
	}


	public void setCountToken(int countToken) {
		this.countToken = countToken;
	}


	@Override
	public String toString() {
		return "TokenDataVO [data=" + Arrays.toString(data) + ", countToken=" + countToken + "]";
	}

	
}
