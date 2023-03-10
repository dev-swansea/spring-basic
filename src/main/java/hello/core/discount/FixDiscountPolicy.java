package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

  private int discountFixAmount = 1000; // ! 1000원 고정할인, vip만

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) return discountFixAmount; else return 0; // ! enum은 == 으로 비교하는게 맞다.
  }
}
