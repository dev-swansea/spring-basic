package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderImpl;
import hello.core.order.OrderService;

public class OrderApp {

  public static void main(String[] args) {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderImpl();

    Long memberId = 1L;
    Member member = new Member(memberId, "suwan", Grade.VIP);
    memberService.joinMember(member);

    Order order = orderService.createOrder(memberId, "suwan", 10000);

    System.out.println("order =>" + order);
  }
}