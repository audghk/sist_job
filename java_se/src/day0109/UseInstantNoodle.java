package day0109;

public class UseInstantNoodle {

	public static void main(String[] args) {

		InstantNoodle in=new InstantNoodle();
		
		in.setServing(1);
		in.setContents(3);
		in.setSpicy("매운");
		
		System.out.printf("라면의 양 %d인분, 라면 내용물 개수 %d개, 라면의 맵기 %s맛\n", in.getServing(), in.getContents(), in.getSpicy());
		String result = in.write("이 라면은 ");
		System.out.printf(result);
	}

}
