package hello.core.discount;

import static org.assertj.core.api.Assertions.assertThat;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicyTest {

  RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

  @Test
  @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
  void vip_d() {
    // given
    Member member = new Member(1L, "suwan", Grade.VIP);

    // when
    int discount = discountPolicy.discount(member, 50000);

    // then
    assertThat(discount).isEqualTo(5000);
  }

  // 실패의 경우도 작성해줘야 한다.
  @Test
  @DisplayName("VIP가 아니면 할인 적용 ㄴㄴ")
  void basic_d() {
    // given
    Member member = new Member(1L, "suwan", Grade.BASIC);

    // when
    int discount = discountPolicy.discount(member, 30000);

    // then
    assertThat(discount).isEqualTo(0);
  }
}
