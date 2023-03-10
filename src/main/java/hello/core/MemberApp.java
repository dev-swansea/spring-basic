package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

  public static void main(String[] args) {
    // AppConfig appConfig = new AppConfig();
    // MemberService memberService = appConfig.memberService();
    /*
     * 스프링은 applicationContext으로 시작이 된다. -> 이게 컨테이너라고 보면 된다.
     * 얘가 모든 객체(Bean)을 관리해준다.
     * AppConfig의 객
     */
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
      AppConfig.class
    );
    MemberService memberService = applicationContext.getBean(
      "memberService",
      MemberService.class
    );
    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.joinMember(member);
    Member findMember = memberService.findMember(1L);
    System.out.println("new member = " + member.getName());
    System.out.println("find Member = " + findMember.getName());
  }
}
