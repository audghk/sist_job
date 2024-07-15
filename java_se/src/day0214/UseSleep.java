package day0214;

import java.util.Random;

//1. Runnable Interface를 구현
public class UseSleep implements Runnable {

	//2. run method를 Override
	@Override
	public void run() {
		//3. Thread로 처리할 코드 정의(동시에 실행 되어야 할 코드)
//		int num=(int)Math.random();
		Random num=new Random();
		System.out.print("loading");
		try {
			for(int i=0; i<10; i++) {
				System.out.print(" . ");
				Thread.sleep(num.nextInt(10)+1000);//랜덤 시간동안 쉼 1000=>1초
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("finish");
		
	}
	
	public static void main(String[] args) {
		//4. 자식클래스를 객체화
		UseSleep us=new UseSleep();
		//5. Thread와 has a
		Thread t=new Thread(us);
		//6. start() 호출
		t.start();
		
	}


}
