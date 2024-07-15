package day0117;

/**
 * Person 클래스의 자식클래스를 사용하기 위해서 만드는 클래스.
 */
public class UsePerson {

	private void usePerson() {
		
		//코드의 재사용성: 부모클래스의 method, 변수를 내 클래스에 존재하는 것처럼 사용.
		HongGilDong hgd=new HongGilDong();
		hgd.setName("홍길동");
		System.out.printf("눈 %d, 코 %d, 입 %d, 이름 %s\n", hgd.getEye(), hgd.getNose(), hgd.getMouth(), hgd.getName());
		
		System.out.println(hgd.fight(5));//6->7
		System.out.println(hgd.fight(6));//7->8
		System.out.println(hgd.fight(8));//7->8
		System.out.println(hgd.fight(9));//8->7
		System.out.println(hgd.getLevel());//7

		System.out.println("----------------------------------------------");
		
		Clark superman=new Clark();
		//코드의 재사용성: 부모클래스의 method, 변수를 내 클래스에 존재하는 것처럼 사용.
		superman.setName("클락 켄트");
		System.out.printf("눈 %d, 코 %d, 입 %d, 이름 %s\n", superman.getEye(), superman.getNose(), superman.getMouth(), superman.getName());
		
		System.out.println(superman.power("다이아몬드"));
		System.out.println(superman.power("크립토나이트"));
		System.out.println(superman.power("짱돌"));
		System.out.println(superman.power);
	
//		MyeongHwa mh=new MyeongHwa();
//		System.out.println("내가 잘하는 일 : "+mh.doWell("코딩"));
				
		System.out.println("----------------------------------------------");
		
		//코드의 재사용성 : 부모클래스에 존재하는 변수나 method를 자식클래스에서
		//자식의 객체명으로 사용하는 것. => 부모에서 제공하는 기능이 자식과 맞지 않는 상황발생!!
		System.out.println(hgd.eat());
		System.out.println(superman.eat());
		System.out.println(hgd.eat("뜨끈한 국밥", 3));
		System.out.println(superman.eat("스테이크", 10));
		
		System.out.println(hgd);//toString() method가 호출되었기 때문이다.
		System.out.println(superman);//toString() method가 호출되었기 때문이다.
		
		System.out.println("----------------------------------------------");

		System.out.println("추진력 : "+superman.drivingForce());
		System.out.println("양력 : "+superman.left());
	
	
	
	
	}
	
	
	public static void main(String[] args) {

		UsePerson up=new UsePerson();
		up.usePerson();
		
	}

}
