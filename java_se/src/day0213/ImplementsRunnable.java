package day0213;

/**
 * 
 */
//1. Runnable interface를 구현
public class ImplementsRunnable implements Runnable {

	//2. run method의 Override
	@Override
	public void run() {
		//3. Thread로 동작해야할 코드를 정의(동시에 실행되어야 할 코드를 정의)
		for(int i=0; i<500; i++) {
			System.out.println("run i----->"+i);
		}
	}

	public void test() {
		for(int i=0; i<500; i++) {
			System.out.println("test i=====>"+i);
		}
	}
	
	public static void main(String[] args) {
		//4. 자식클래스를 객체화한다.
		ImplementsRunnable ir=new ImplementsRunnable();
		//5. Thread와 has a관계로 객체화
		Thread t=new Thread(ir);
		//6. Thread의 start()를 호출하여 동시에 실행되어야할 코드를 정의
		t.start();
		ir.test();
	}
}
