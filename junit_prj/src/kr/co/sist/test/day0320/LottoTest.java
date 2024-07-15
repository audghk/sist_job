package kr.co.sist.test.day0320;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import kr.co.sist.day0320.TestLotto;

class LottoTest {
  @DisplayName("로또번호 테스트")
  @Test
  void testCreateLotto() {
    // given
    TestLotto tl = new TestLotto();
    int money = 1000;
    // when
    // List<Integer> list = tl.createLotto(money);
    // System.out.println(list);
    assertDoesNotThrow(() -> tl.createLotto(money));// 예외가 발생하지 않니
    // then
    // assertEquals(list.size(), 6);
    // assertThrows(RuntimeException.class, () -> {
    // System.out.println("예외");
    // });
  }

  // @Disabled
  @DisplayName("금액 유효 테스트")
  @Test
  void testIsValidMoney() {
    // given
    TestLotto tl = new TestLotto();
    int money = 1000;// 다른 금액으로 변경
    // when
    boolean flag = tl.isValidMoney(money);
    // then
    assertTrue(flag);
  }

}
