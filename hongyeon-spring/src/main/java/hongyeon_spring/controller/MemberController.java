package hongyeon_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hongyeon_spring.service.MemberService;

@Controller
public class MemberController {
	//service는 new해서 새로운 객체를 만들지 않고 하나만 생성해놓고 공용으로 쓰면 됨
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	
}
