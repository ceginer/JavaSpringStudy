package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


//    이전에는 static 파일에 있던 hello.html과 매칭 되었었는데 현재는 home.html과 매칭
//    이유: 컨트롤러(HomeController)가 정적 파일(hello.html)보다 우선순위가 높으므로

    @GetMapping("/") //: localhost:8080으로 가면 바로 home() 리턴
    public String home(){
        return "home";
    }
}