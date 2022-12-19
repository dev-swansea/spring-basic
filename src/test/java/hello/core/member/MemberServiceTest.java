package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.BeforeEach;

class MemberServiceTest {

  MemberService memberService;

  // test이전 무조건 실행해라
  @BeforeEach
  public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
  }
}
