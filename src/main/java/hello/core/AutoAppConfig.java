package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
  basePackages = "basic",
  // AppConfig가 자동으로 등록되면 안되기 때문에 => 충돌 발생 위험( 둘 다 Configuration 어노테이션에 COmponent가 붙어있기 떄문에 안전성을 위해 뺌)
  excludeFilters = @ComponentScan.Filter(
    type = FilterType.ANNOTATION,
    classes = Configuration.class
  )
)
public class AutoAppConfig {}
