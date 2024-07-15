package day0117;

public class UseDog {

	private void useDog() {
		Chihuahua ch=new Chihuahua();
		ch.setName("치와와");
		System.out.println(ch.dogWork("애교",1));
//		System.out.println(ch);
		
		Malamute mm=new Malamute();
		mm.setName("말라뮤트");
		System.out.println(mm.dogWork("썰매끌기",2));
		System.out.println(mm);
	}
	
	public static void main(String[] args) {

		UseDog ud=new UseDog();
		ud.useDog();

	}

}
