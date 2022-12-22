package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * AppConfig 호출 순서 -> 사실 순서보장은 없다.
 *
 * 3번의 memberRepo가 호출되야 한다.
 *
 * call AppConfig.memberService
 * Call AppConfig.memberRepository
 * call AppConfig.memberRepository
 * call AppConfig.orderService
 * call AppConfig.membeRepository
 *
 *  실제, 이악물고 싱글톤
 * Call AppConfig.memberService()
 * Call AppConfig.memberRepository()
 * Call AppConfig.orderService()
 */

@Configuration //! 설정정보에 configuration을 적어준다.
public class AppConfig {

  @Bean //! 이후 이렇게 Bean을 적어주면, 스프링 컨테이너에 등록된다.
  public MemberService memberService() {
    System.out.println("Call AppConfig.memberService()");
    return new MemberServiceImpl(memberRepository());
  }

  @Bean
  public OrderService orderService() {
    System.out.println("Call AppConfig.orderService()");
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  @Bean
  public MemberRepository memberRepository() {
    System.out.println("Call AppConfig.memberRepository()");
    return new MemoryMemberRepository();
  }

  @Bean
  public DiscountPolicy discountPolicy() {
    return new RateDiscountPolicy();
  }
}
// 배우를 교체하는, 구성에 대한 부분을 다 책임진다.
