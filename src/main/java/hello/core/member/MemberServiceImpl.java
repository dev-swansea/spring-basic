package hello.core.member;

public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }

  @Override
  public void joinMember(Member member) {
    // TODO Auto-generated method stub
    memberRepository.save(member);
  }
}
