package hongyeon_spring.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") // 웹 브라우저에 /hello가 들어오면 밑의 함수를 실행
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // resources/templates/hello.html 렌더링 해라. 모델을 넘기면서
    }
}
