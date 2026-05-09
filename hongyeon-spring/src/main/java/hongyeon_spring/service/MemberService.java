package hongyeon_spring.service;

import hongyeon_spring.domain.Member;
import hongyeon_spring.repository.MemberRepository;
import hongyeon_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원가입
    public Long join(Member member) {
        //같은 이름의 중복 회원x
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> { //null이 아니라 값이 있으면 동작(optional 때문에 사용), 들어온 값(멤버) m, 과거엔 result == null 이런식으로 썼는데 optional 덕분에 ifPresent로 작성
//            throw new IllegalStateException("이미 존재하는 회원입니다");
//        });
        //만약 optional로 감싸진 멤버 객체를 바로 꺼내고 싶으면 Member member = result.get()해서 꺼내면 됨, 권장x
        // result.orElseGet(), 값이 있으면 optional에서 꺼내고 없으면 특정 메소드를 실행하거나 디폴트 값을 넣어서 꺼내거나

        //바로 ifPresent를 사용할 수도 있음 어차피 optional로 리턴하니까
        //이렇게 멤버를 가져오는 덩어리를 메소드화 시키는 것이 좋음
//        memberRepository.findByName(member.getName())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
