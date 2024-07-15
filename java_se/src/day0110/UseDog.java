package day0110;

public class UseDog {

	public static void main(String[] args) {

		Dog d=new Dog();
		
		//공통 메소드 넣기 - 애완동물, 수명, 포유류, 다리 네개 등
		System.out.printf("이 강아지는 %s이고, 수명은 %d년이다. 다리 개수는 %d개다.\n", d.getKind(), d.getLifeLength(), d.getLeg());
		
		//특징 메소드 넣기 - 성격, 종류, 환경 등
		String result=d.write("치와와", "사납");
		System.out.println(result);
		result=d.write("허스키", "활발하");
		System.out.println(result);
		result=d.write("시바", "순하");
		System.out.println(result);
		
		
	}

}
