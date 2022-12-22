package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memberSerice2")
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  @Autowired // ac.getBean(MemberRepository.class) 와 같은 의존성을 주입해줌
  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }

  @Override
  public void joinMember(Member member) {}

  // test용도
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
