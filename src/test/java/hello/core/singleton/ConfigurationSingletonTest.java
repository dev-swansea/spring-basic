package hello.core.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.hamcrest.core.IsSame;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

  @Test
  void configrationTest() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(
      AppConfig.class
    );

    // 구체타입으로 선언한 이유는, test용 메서드를 만들어놨잔슴
    MemberServiceImpl memberService = ac.getBean(
      "memberService",
      MemberServiceImpl.class
    );
    OrderServiceImpl orderService = ac.getBean(
      "orderService",
      OrderServiceImpl.class
    );
    MemberRepository memberRepo = ac.getBean(
      "memberRepository",
      MemberRepository.class
    );
    MemberRepository memberRepository1 = memberService.getMemberRepository();
    MemberRepository memberRepository2 = orderService.getMemberRepository();

    // ! 3놈 다 똑같은 놈, 3번의 new가 실행되는데, 왜지 ..
    // this is singleton baby
    System.out.println(
      "memberRepository => memberService /" + memberRepository1
    );
    System.out.println(
      "memberRepository => orderService /" + memberRepository2
    );
    System.out.println("memberRepo => memberRepo /" + memberRepo);
    assertThat(memberService.getMemberRepository()).isSameAs(memberRepo);
    assertThat(orderService.getMemberRepository()).isSameAs(memberRepo);
  }
}
