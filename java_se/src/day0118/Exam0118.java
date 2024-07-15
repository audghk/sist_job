package day0118;

/**
 * 1. 아래의 데이터로 배열을 만들고, 임의의 방하나의 값을 출력.
 *    "어쩔티비,저쩔티비,뇌절티비,안물티비,안궁티비,때리고싶쥬~,못때리쥬~,개킹받쥬~"
 *    
 * 2. 8자리의 영문자,숫자로 구성된 임의의 비밀번호를 생성하여 반환하는 일을 하는 method를 작성하여 사용(출력)
 *    48~57, 65~90, 97~122 10 26 26
 * 
 * 3. 로또번호(1~45의 수 중 하나를 뽑고, 6자리의 세트) 구하여 반환하는 method를 작성하여 사용
 *    (중복값이 들어가면 안되고 오름차순 정렬되어 출력되어야한다.)
 */
public class Exam0118 {

	public static void main(String[] args) {
		
		//1번
		String[] mzArr1="어쩔티비,저쩔티비,뇌절티비,안물티비,안궁티비,때리고싶쥬~,못때리쥬~,개킹받쥬~".split(",");
		System.out.println(mzArr1[(int)(Math.random()*(mzArr1.length))]);
		
		//2번 고민의 흔적입니다 무시하세요오//
//		char[] randomPassWord=new char[8];
//		char passWord=(char)(Math.random());
//		for(int j=0; j<randomPassWord.length; j++) {
//			if(passWord==(char)((Math.random()*10)+48) || passWord==(char)((Math.random()*26)+65) || passWord==(char)((Math.random()*26)+97)) {
//				randomPassWord[j]=passWord;				
//			}
//			System.out.print(randomPassWord[j]+"");
//		}
		
//		char[] randomPassWord=new char[8];
//		
//		for(int j=0; j<randomPassWord.length; j++) {
//			
//			char passWord1=(char)((Math.random()*10)+48);
//			char passWord2=(char)((Math.random()*26)+65);
//			char passWord3=(char)((Math.random()*26)+97);
//			
////			System.out.println(passWord1);
////			System.out.println(passWord2);
////			System.out.println(passWord3);
//			
//			int Rand=(int)(Math.random());
//			
//			if(Rand*3==0) {
//				randomPassWord[j]=passWord1;	
//			}else if(Rand*3==1) {
//				randomPassWord[j]=passWord2;
//			}else{
//				randomPassWord[j]=passWord3;	
//			}
//			
//			System.out.print(randomPassWord[j]+"");
//		}
		
		//2번
		char[] randomPassWord=new char[8];
		
		for(int j=0; j<randomPassWord.length; j++) {
			
			char passWord1=(char)((Math.random()*10)+48);
			char passWord2=(char)((Math.random()*26)+65);
			char passWord3=(char)((Math.random()*26)+97);
			
			double Random=Math.random();
			int randNum=(int)(Random*3);
			
			switch(randNum) {
			case 0://constant로 하는게 가독성이 좋음 //ex) public static final int UPPER=0;
				randomPassWord[j]=passWord1;
				break;//안넣어도 상관없음
			case 1:
				randomPassWord[j]=passWord2;
				break;
			default:
				randomPassWord[j]=passWord3;
				break;
		}
			
			System.out.print(randomPassWord[j]+"");
		}
		System.out.println();
		
		//3번
		int[] randomLotto=new int[6];
		int number=0;
		for(int j=0; j<randomLotto.length; j++) {
			number=(int)((Math.random()*45)+1);
			randomLotto[j]=number;
//			System.out.print(randomLotto[j]+" ");
		}
		
//		for(int i=0; i<randomLotto.length; i++) {
//			for(int j=0; j<randomLotto.length; j++) {
//				if(randomLotto[j]==randomLotto[i]) {
//								
//				}else {
//				}
//			
//			}
//		}
		
//		int top=randomLotto[0];
//		for(int i=0; i<randomLotto.length; i++) {
//			if(randomLotto[i+1]<randomLotto[i]) {
//				randomLotto[i+1]=randomLotto[i];
//			}
//		}
//		System.out.println(top);
		
		
		
		
		for(int i=0; i<randomLotto.length; i++) {
			System.out.print(randomLotto[i]+" ");
		}
		
		
		
	}
	
}
