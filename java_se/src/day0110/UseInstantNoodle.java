package day0110;

public class UseInstantNoodle {

	public static void main(String[] args) {

		InstantNoodle in=new InstantNoodle();
		
		in.setServing(1);
		in.setContents(3);
		in.setSpicy("매운");
		
		System.out.printf("라면의 양 %d인분, 라면 내용물 개수 %d개, 라면의 맵기 %s맛\n", in.getServing(), in.getContents(), in.getSpicy());
		String result = in.write("신라면");
		System.out.printf("%s\n", result);
		
		InstantNoodle in2=new InstantNoodle(1, 3, "보통");
		System.out.printf("라면의 양 %d인분, 라면 내용물 개수 %d개, 라면의 맵기 %s맛\n", in2.getServing(), in2.getContents(), in2.getSpicy());
		result = in2.write("너구리");
		System.out.printf(result);
		
	}

}
