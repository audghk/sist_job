package day0103;

/**
 * 다중 if (else ~ if) : 연관된 여러 조건을 비교할 때 사용.
 * 문법)
 * 
 * if (조건식){
 *  조건에 맞을때 수행할 문잘들
 * } else if(조건식){
 * 조건에 맞을 때 수행할 문장들
 * }else {
 * 조건에 맞지 않을 때 수행할 문장들
 * }
 */
public class TestElseIf {

	
	public static void main(String[] args) {

		//점수는 0보다 작을 수 없고, 100보다 클수없다. 0보다 작다면 "0보다 작아서 실패",
		//100보다 크다면 "100보다 커서 실패", 그렇지 않다면(0~100사이) "성공!"을 출력
		
		int score=80;
		
		if(score < 0) {
			System.out.println("0보다 작아서 실패");
		}else if(score > 100) {
			System.out.println("100보다 커서 실패");
		}else {
			System.out.println("성공!");
		}
		
		//char 형의 변수에는 임의의 문자가 할당되어있다.
		//할당된 문자가 대문자인지 소문자인지 숫자인지 그렇지 않다면
		//영어나 숫자가 아닙니다 출력
		char c='3';
		
		if(c>=65 && c<=90) {
			System.out.println("대문자");
		}else if(c>=97 && c<=122) {
			System.out.println("소문자");
		}else if(c>=48 && c<=57) {
			System.out.println("숫자");
		}else {
			System.out.println("영어나 숫자가 아닙니다.");
		}
				
		//태어난 해를 저장하는 변수를 선언하고 자신이 태어난 해를 할당한다.
		//태어난 해의 띠를 출력하세요.
		int myYear=1998;
		if(myYear%12==Zodiac.MONKEY) {
			System.out.println("원숭이");
		}else if(myYear%12==Zodiac.CHICKEN) {
			System.out.println("닭");
		}else if(myYear%12==Zodiac.DOG) {
			System.out.println("개");
		}else if(myYear%12==Zodiac.PIG) {
			System.out.println("돼지");
		}else if(myYear%12==Zodiac.MOUSE) {
			System.out.println("쥐");
		}else if(myYear%12==Zodiac.COW) {
			System.out.println("소");
		}else if(myYear%12==Zodiac.TIGER) {
			System.out.println("호랑이");
		}else if(myYear%12==Zodiac.RABBIT) {
			System.out.println("토끼");
		}else if(myYear%12==Zodiac.DRAGON) {
			System.out.println("용");
		}else if(myYear%12==Zodiac.SNAKE) {
			System.out.println("뱀");
		}else if(myYear%12==Zodiac.HORSE) {
			System.out.println("말");
		}else {
			System.out.println("양");
		}
		
	}

}
