package day0426;

/**
 * 접속자가 있었을 때 이전 접속자의 수와 새로운 접속자의 수를 누적합 하는 VO
 */
public class CounterVO {
  private int cnt;

  public CounterVO() {
    System.out.println("CounterVO의 기본 생성자");
  }// CounterVO

  public int getCnt() {
    return cnt;
  }

  public void setCnt(int cnt) {
    this.cnt += cnt;// 누적합
  }



}
