package hello.core.member;

// 구현체가 하나일 땐 impl을 관례상 붙힌다.
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository = new MemoryMemberRepository();

  @Override
  public void joinMember(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
