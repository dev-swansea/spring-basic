package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

  MemberService memberService = new MemberServiceImpl();
  OrderService orderService = new OrderImpl();

  @Test
  void createOrder() {
    Long memberId = 1L; // 이거 그냥 기본형으로 long해도 되는데, db에는 null이 들어갈 수도 있어서 일부러 wrapper클래스 로 했다함,
    Member member = new Member(memberId, "suwan", Grade.VIP);
    memberService.joinMember(member);

    Order order = orderService.createOrder(memberId, "notebook", 50000);
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}
