package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

  private static Map<Long, Member> store = new HashMap<>();

  @Override
  public void save(Member member) {
    store.put(member.getId(), member);
  }

  @Override
  public Member findById(Long memberId) {
    return store.get(memberId);
  }
}
// db확정이 되지않아 메모리용만 만들었다.
