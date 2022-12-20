package hello.core.beanFind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

  private static final String assertThat = null;
  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
    AppConfig.class
  );

  @Test
  @DisplayName("빈 이름으로 조회")
  void findBeanName() {
    MemberService memberService = ac.getBean(
      "memberService",
      MemberService.class
    );
    System.out.println("memberService = " + memberService);
    System.out.println("memberService.getClass" + memberService.getClass());

    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("이름 없이 타입으로만 조회")
  void findBeanType() { // 같은 타입이면 좀 곤란해지는 상황이 생긴다.
    MemberService memberService = ac.getBean(MemberService.class);

    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("구체 타입으로 조회")
  void findBeanName2() {
    // 인터페이스(MemberService)로 조회 말고 리턴타입으로 조회
    // 물론 구체적인건 안좋다(의존성 떨어짐) => 역할에 의존해야 하기 때문에, 좋은 코드는 아니지만 혹시 모르니 ..
    MemberService memberService = ac.getBean(
      "memberService",
      MemberServiceImpl.class
    );

    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  /*
   * 항상 실패했을 때의 상황도 테스트 해야한다.
   * 람다식 익혀놓기
   */
  @Test
  @DisplayName("없는 빈 이름 조회")
  void findBeanByNoName() {
    // ac.getBean("ThereIsNoName", MemberService.class);

    assertThrows(
      NoSuchBeanDefinitionException.class,
      () -> ac.getBean("ThereIsNoName", MemberService.class)
    );
  }
}
