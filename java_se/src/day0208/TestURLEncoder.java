package day0208;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestURLEncoder {

	public static void main(String[] args) {
		//
		
		String str="즐거운 설명절 되세요.";
		System.out.println("원본 : "+str);
		try {
			//3byte의 한글을  Network으로 내보내기 위해서
			String encode=URLEncoder.encode(str, "UTF-8");
			System.out.println("인코딩 : "+encode);
			//알아 볼 수 없는 encode된 한글을 알아 볼 수 있게 재조합.
			String decode=URLDecoder.decode(encode, "UTF-8");
			System.out.println("디코딩 : "+decode);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
