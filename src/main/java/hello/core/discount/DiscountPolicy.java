package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
  /*
   * @return 할인 대상 금액!! 금액만 리턴해준다.
   */

  int discount(Member member, int price);
}
