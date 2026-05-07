package hongyeon_spring.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // 웹 브라우저에 /hello가 들어오면 밑의 함수를 실행
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); //키 data, 값 hello!!
        return "hello"; // resources/templates/hello.html 렌더링 해라. 모델을 넘기면서
    }

    @GetMapping("hello-mvc")
    //입력값 name을 받음
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name); //키 name, 값 name
        return "hello-template";
    }
    
    @GetMapping("hello-string")
    @ResponseBody //http 프로토콜에서 header부와 body부가 있을 때, body부에 리턴값을 직접 넣어주겠다는 뜻
    public String helloString(@RequestParam("name") String name) {
    	return "hello " + name; // "hello string", 뷰가 없고 클라이언트에게 바로 해당 문자가 내려감
    }
    
    @GetMapping("hello-api")
    @ResponseBody
    
    public Hello helloApi(@RequestParam("name") String name) {
    	Hello hello = new Hello(); //객체 생성
    	hello.setName(name);
    	return hello; //객체를 넘겨줌
    }
    
    static class Hello { //static 쓰면 클래스 안에 또 클래스 만들 수 있음 사용은 상위클래스명.하위클래스명
    	private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
    	
    	
    }
}
