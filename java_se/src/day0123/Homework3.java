package day0123;

import java.time.LocalDate;
import java.util.Calendar;

public class Homework3 {
	public static final int START_DAY = 1;

	public Homework3() {

	}

	/*
	 * <문제 1> Calendar 클래스를 사용하여 1월의 달력 출력하기 String[] dates = {"", "일요일", "월요일",
	 * "화요일", "수요일", "목요일", "금요일", "토요일"
	 */
	public void question1() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 0);
		System.out.println("=======================1월=======================");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int day = 0;
		int dayOfWeek = 0;//요일저장
		
		//////////////////////////놓침~!~!///////////////////////////////////
		for (int tempday = 1;; tempday++) {
			// 증가하는 일을 달력 객체에 설정
			cal.set(Calendar.DAY_OF_MONTH, tempday);
			day = cal.get(Calendar.DAY_OF_MONTH);// 설정된 일자를 가져온다

			if (day != tempday) {// 설정된 일자와 임시 일자가 같지 않으면
				// 월이 끝났기 때문에 반복문을 빠져나간다.
				break;
			} // end if
			dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 설정된 일자의 요일 얻기
			switch (day) {
			case START_DAY:
				// 1일을 출력하기 전 공백 출력
				for (int i = 1; i < dayOfWeek; i++) {
					System.out.print("\t");
				} // end for

			}// end switch
			System.out.print(day + "\t");// 일자 줄력

			switch (dayOfWeek) {// 설정된 일자가
			case Calendar.SATURDAY:// 토요일이면 줄 변경
				System.out.println();
			}

//        for (int i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
//            cal.set(Calendar.DAY_OF_MONTH, i);
//            System.out.print(cal.get(Calendar.DAY_OF_MONTH) + "\t");
//            if (i % 7 == 6) {
//                System.out.println();
//            }
		}
	}

	/*
	 * <문제 2> 매개변수로 년, 월을 입력받아 해당 년, 월에 대한 마지막 일까지를 일차원 배열에 할당하여 반환하는 작업을 하는 method
	 * 작성 - lengthOfMonth 사용
	 */
	public int[] question2(int year, int month) {
		LocalDate lDate1 = LocalDate.of(year, month, 1);
		int endOfMonth = lDate1.lengthOfMonth();
		int[] dayPerMonth = new int[endOfMonth];

		for (int i = 0; i < endOfMonth; i++) {
			dayPerMonth[i] = i + 1;
		}

		return dayPerMonth;
	}

	public static void main(String[] args) {
		Homework3 myHW = new Homework3();
		myHW.question1();
		System.out.println("\n============================================================");
		int[] january = myHW.question2(2024, 2);
		for (int i : january) {
			System.out.print(i + " ");
		}
	}
}
