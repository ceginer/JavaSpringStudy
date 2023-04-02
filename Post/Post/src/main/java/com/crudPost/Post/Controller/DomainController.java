package com.crudPost.Post.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DomainController {
    // 게시물 목록을 보여준다.
    // 컨트롤러의 메소드가 리턴하는 문자열은 템플릿 이름이다.
    // http://localhost:8080/-> "list" 0 (forward) 800
    // classpath: /templates/list.html|
    // 뒤에 .html 은 알아서 붙혀준다.

    @GetMapping("/")
    public String list(){
        return "list";
    }
}
