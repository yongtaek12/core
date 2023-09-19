package hello.core.member;

public interface MemberRepository {

    // 회원을 저장
    void save(Member member);
    
    // 회원을 찾는 기능
    Member findByid(Long memberId);
}
