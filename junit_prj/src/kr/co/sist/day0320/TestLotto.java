package kr.co.sist.day0320;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TestLotto {

  public List<Integer> createLotto(int money) {
    List<Integer> list = null;

    if (!isValidMoney(money)) {
      throw new RuntimeException("로또의 기본 금액은 1000원입니다.");
    }

    list = generate();

    return list;
  }

  public boolean isValidMoney(int money) {
    return money == 1000;
  }

  private List<Integer> generate() {
    return new Random().ints(1, 45 + 1).distinct().limit(6).boxed().sorted(/* Comparator.reverseOrder() */)
        .collect(Collectors.toList());
  }

  // public static void main(String[] args) {
  // TestLotto tl = new TestLotto();
  // System.out.println(tl.createLotto(1000));
  // }

}
