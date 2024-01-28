package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // AppConfig를 통해 객체(구체클래스 참조주소)를 주입 받을 수 있도록 생성자를 추가
    // MemberServiceImpl에서는 MemberRepository 인터페이스만 의존하고 있으므로 DIP가 완성된다.
    // 이제 "의존관계에 대한 고민은 외부"에 맡기고 "실행에만 집중"하면 된다.

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
