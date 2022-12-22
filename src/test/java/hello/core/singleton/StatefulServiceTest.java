package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

  @Test
  void statefulServiceSingleton() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(
      TestConfig.class
    );

    StatefulService statefulService1 = ac.getBean(StatefulService.class);
    StatefulService statefulService2 = ac.getBean(StatefulService.class);

    // ThreadA: A사용자 1만원 주문
    int userAPrice = statefulService1.order("userA", 10000);
    // ThreadA: B사용자 2만원 주문
    int userBPrice = statefulService1.order("userB", 20000);

    /*
     * ThreadA: 사용자A 주문 금액 조회 => 1만원
     * 인스턴스가 같기 때문에 중간에 b가 바꿔치기 해버린다.
     * 멀티쓰레드는 무섭다.
     */

    int price = userAPrice;
    System.out.println(price);
    // => 만원이 제대로 나오게 된다.
    Assertions.assertThat(userAPrice).isNotSameAs(userBPrice);
  }

  static class TestConfig {

    @Bean
    public StatefulService statefulService() {
      return new StatefulService();
    }
  }
}
