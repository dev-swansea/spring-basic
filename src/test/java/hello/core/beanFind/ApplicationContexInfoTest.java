package hello.core.beanFind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContexInfoTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
    AppConfig.class
  );

  @Test
  @DisplayName("모든 빈 출력하기")
  void findAll() {
    // 빈에 정의된 이름을 정렬
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();

    // iter snippet!!
    // for (String beanDefinitionName : beanDefinitionNames) {
    //   Object bean = ac.getBean(beanDefinitionName);
    //   System.out.println(
    //     "name = " + beanDefinitionName + " / object = " + bean
    //   );
    // }
    for (int i = 0; i < beanDefinitionNames.length; i++) {
      Object bean = beanDefinitionNames[i];
      Object bean2 = ac.getBean(beanDefinitionNames[i]);
      System.out.println(
        bean + "-------> name // " + bean2 + "---------> value"
      );
    }
  }

  // }

  @Test
  @DisplayName("Print Application Bean ")
  void findApplicationBean() {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();

    for (String beanDefinitionName : beanDefinitionNames) {
      //? getBeanDefinition 이친구는 bean의 meta데이터라고 한다.
      BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

      //* 스프링이 내부에서 등록한 빈이 아니라, 내가 필요헤 의해 등록한 빈이나 외부 라이브러리 같은 것들
      /*
       * Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
       * Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
       */
      // 위와같은 상황만 출력 => 등록한 빈만 출력된다.
      if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {}
    }
  }
}
