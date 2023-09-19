package hello.core.member;

public class MemberSeviceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberSeviceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override

    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(long memberId) {
        return  memberRepository.findByid(memberId);
    }
}
