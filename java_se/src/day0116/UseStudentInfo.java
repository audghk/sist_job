package day0116;

/**
 * 
 */
public class UseStudentInfo {

	public static void main(String[] args) {

		StudentInfoVO siVO=
				new StudentInfoVO(1, "루피", 182.4, 65.5,"test@test.com");
		
		StudentInfoVO siVO2=
				new StudentInfoVO(2, "샹디", 192.1, 80.5,"test@test.com");
		
		System.out.println(siVO.getNum()+" "+siVO.getName()+" "+ siVO.getHeight());
		System.out.println(siVO2.getNum()+" "+siVO2.getName()+" "+ siVO2.getHeight());
	
		
	}

}
