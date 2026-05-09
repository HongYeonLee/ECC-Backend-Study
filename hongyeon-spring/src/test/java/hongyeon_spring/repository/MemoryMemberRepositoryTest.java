package hongyeon_spring.repository;

import hongyeon_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //각 테스트 메소드들이 끝난 뒤에 호출되는 콜백 메소드, 테스트 데이터 지우기 위함
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); //optional에서 값을 꺼내야 하므로 get() 이용
        // System.out.println("result = " + (result == member));
        // Assertions.assertEquals(member, result); //매개변수로 기대값, 실제값 전달. 둘이 동일한지 검사해줌
        // Assertions.assertEquals(member, null);
        // Assertions.assertThat(member).isEqualTo(result);
        assertThat(member).isEqualTo(result); //static으로 클래스 넣어서 더 편하게 작성
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
