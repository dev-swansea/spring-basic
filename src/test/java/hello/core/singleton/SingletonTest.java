package hello.core.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

  @Test
  @DisplayName("스프링 없는 순수 DI 컨테이너")
  void pureContainer() {
    AppConfig appConfig = new AppConfig();

    // 아래의 두개는 각각 객첼르 생성했기 때문에 참조값이 다르다.
    MemberService memberService1 = appConfig.memberService();
    MemberService memberService2 = appConfig.memberService();

    if (memberService1 != memberService2) {
      System.out.println("다르다");
    }

    // memberService1 != memberService2
    assertThat(memberService1).isNotSameAs(memberService2);
  }

  @Test
  @DisplayName("싱글톤 패턴을 적용한 객체사용")
  void singletonServiceTest() {
    SingleTonService singleton1 = SingleTonService.getInstance();
    SingleTonService singleton2 = SingleTonService.getInstance();

    // 같은 객체를 가져온다.
    System.out.println(singleton1 + "------1");
    System.out.println(singleton2 + "-------2");

    /*
     *  isEqual 자바의 eqauls
     *  asSame == 참조를 비교하는,
     */

    assertThat(singleton1).isSameAs(singleton2);
  }

  @Test
  @DisplayName("스프링 컨테이너와 싱글톤")
  void springContainer() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(
      AppConfig.class
    );

    MemberService memberService1 = ac.getBean(
      "memberService",
      MemberService.class
    );
    MemberService memberService2 = ac.getBean(
      "memberService",
      MemberService.class
    );

    if (memberService1 == memberService2) {
      System.out.println("같다");
    }

    // memberService1 != memberService2
    assertThat(memberService1).isSameAs(memberService2);
  }
}
// 종속까지 생각하면 한 번의 요청에 4개의 객체를 생성한다.
