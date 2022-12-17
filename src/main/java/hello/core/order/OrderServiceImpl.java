package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository = new MemoryMemberRepository();
  /*
   * Fix -> Rate, 이게 큰 문제..라고? 그냥 한 줄 바꾸면 되는건데
   * 에를 들면, 화석연료 자동차를 타다가 전기차로 바껐을 때, 라이센스를 다시 취득해야되는, 그런 상황이라고 함 ...
   */
  // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
  private DiscountPolicy discountPolicy; //! 구체화에 의존 ㄴㄴ => 인터페이스에만 의존, 근데 이러면 nullPointException,

  // 지금까진 DIP만 지킨거
  //! 이 문제를 해결하며녀 누가 클라인 OrderServiceImpl에 DiscountPolicy에 구현객체를 생성하고 주입해줘야 한다.
  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);
    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
