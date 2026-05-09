package hongyeon_spring.repository;

import hongyeon_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원을 저장하면 저장된 회원이 리턴
    Optional<Member> findById(Long id); //리턴값이 null인 경우(회원이 null) optional로 감싸서 리턴
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
