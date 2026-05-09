package hongyeon_spring.repository;

import hongyeon_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); //멤버 아이디와 멤버 객체 저장, 실무에서는 공유 변수일 때는 동시성 문제로 Concurrent HashMap을 씀
    private static long sequence = 0L; //012..키 값을 생성해줌, 실무에서는 동시성 문제로 atomic long 사용

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //저장소에 넣기 전에 시스템이 고객아이디 결정, name이 고객이 이미 입력해서 저장함
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null 리턴될 경우를 위해 optional로 감쌈
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //고객의 이름과 매개변수로 받은 이름이 같은지 확인, 같은 경우만 필터링됨
                .findAny(); //돌면서 하나라도 찾으면 바로 리턴, 끝까지 돌렸는데 없으면 optional에 null이 포함되서 리턴
    }

    @Override
    public List<Member> findAll() {
        //맵을 리스트로 변환해서 리턴
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
