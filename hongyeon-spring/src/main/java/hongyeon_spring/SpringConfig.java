package hongyeon_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hongyeon_spring.repository.MemberRepository;
import hongyeon_spring.repository.MemoryMemberRepository;
import hongyeon_spring.service.MemberService;

@Configuration
public class SpringConfig {
	//스프링이 스프링 빈에 등록함
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}
