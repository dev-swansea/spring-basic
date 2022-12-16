package hello.core.member;

public interface MemberRepository {
  void save(Member Member);

  Member findById(Long memberId);
}
