package day0123;

import java.time.LocalDate;
import java.util.Calendar;

public class HomeWork2 {
    public HomeWork2() {

    }

    /*
     * <문제 1>
     * Calendar 클래스를 사용하여 1월의 달력 출력하기
     * String[] dates = {"", "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"
     */
    public void question1() {
        Calendar january = Calendar.getInstance();
        System.out.println("=======================1월=======================");
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        System.out.print("\t");

        for (int i = 1; i <= january.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            january.set(Calendar.DAY_OF_MONTH, i);
            System.out.print(january.get(Calendar.DAY_OF_MONTH) + "\t");
            if (i % 7 == 6) {
                System.out.println();
            }
        }
    }

    /*
     * <문제 2>
     * 매개변수로 년, 월을 입력받아 해당 년, 월에 대한 마지막 일까지를 일차원 배열에 할당하여
     * 반환하는 작업을 하는 method 작성
     * - lengthOfMonth 사용
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
        HomeWork2 myHW = new HomeWork2();
        myHW.question1();
        System.out.println("\n============================================================");
        int[] january = myHW.question2(2024, 2);
        for (int i : january) {
            System.out.print(i + " ");
        }
    }
}
