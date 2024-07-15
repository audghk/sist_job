package day0202;

public class Gugudan {

	public void gugu() {
		
		for(int i=2; i<10; i++) {
			for(int j=1; j<10; j++) {
				System.out.println(i+" X "+j+" = "+i*j);
			}
		}
	
	}
	
	public String gugudan() throws GugudanException{
		
		String gugu="";
		
		int num=1;
		if(num<2 && num>9) {
			throw new GugudanException(num + "단은 구구단의 범위가 아닙니다.");
		}
		
		gugu=num+"단을 출력합니다.\n";	
		
		return gugu;
	}
	
	public static void main(String[] args) {

		Gugudan ggd=new Gugudan();
		try {
			String msg=ggd.gugudan();
			System.out.println(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
