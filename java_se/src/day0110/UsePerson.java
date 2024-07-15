package day0110;

/**
 * Person 클래스를 사용하기 위해서 만드는 클래스.
 */
public class UsePerson {

	private void usePerson() {
		
		Person ogong=new Person();// 사람이 태어난 것!
								  // => 기본적으로 가지고 있어야할 값을 가지지 않았다.
								  // => 객체가 생성될 때 기본적으로 가지고 있어야할 값을 설정하는 코드를
								  //    어디에선가 작성해야 됨.
		
		//명사적인 특징
//		ogong.setEye(2);// 눈, 코, 입 설정
//		ogong.setNose(1);
//		ogong.setMouth(1);
		ogong.setName("손오공");
		
		System.out.printf("눈 %d개 코 %d개 입 %d개 이름 %s\n", ogong.getEye(), ogong.getNose(), ogong.getMouth(), ogong.getName());
		
		//동적인 특징 : Overloading
		System.out.println(ogong.eat());
		System.out.println(ogong.eat("돈까스", 10000));
		
		//천진반 객체를 생성
		Person jinban=new Person();
		jinban.setEye(3);
		jinban.setName("천진반");
		System.out.printf("눈 %d개 코 %d개 입 %d개 이름 %s\n", jinban.getEye(), jinban.getNose(), jinban.getMouth(), jinban.getName());
		System.out.println(jinban.eat());
		System.out.println(jinban.eat("선두", 0));
		
		//////////////자신을 객체화하여 사용하는 코드 작성/////////////////////
		Person mh=new Person();
			
//		mh.setEye(2);
//		mh.setNose(1);
//		mh.setMouth(1);
		mh.setName("이명화");
			
		System.out.printf("눈 %d개 코 %d개 입 %d개 이름 %s\n", mh.getEye(), mh.getNose(), mh.getMouth(), mh.getName());
		
		System.out.println(mh.eat());
		System.out.println(mh.eat("김치찌개", 10000));
			
	}
	
	
	public static void main(String[] args) {

		UsePerson up=new UsePerson();
		up.usePerson();
		
	}

}
