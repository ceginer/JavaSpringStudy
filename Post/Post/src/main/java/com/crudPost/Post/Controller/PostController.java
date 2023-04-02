package com.crudPost.Post.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
    // 게시물 목록을 보여준다.
    // 컨트롤러의 메소드가 리턴하는 문자열은 템플릿 이름이다.
    // http://localhost:8080/-> "list" 0 (forward) 800
    // classpath: /templates/list.html|
    // 뒤에 .html 은 알아서 붙혀준다.

    // 맨 처음 리스트
    @GetMapping("/")
    public String list(){
        return "list";
    }

    // /board?id=3 // 파라미터 id , 파라미터 id의 값은 3
    // /board?id=2
    // /board?id=1

    // 각 게시물 id 에 따른 GET
    @GetMapping("/board")
    public String board(@RequestParam("id") int id){
        System.out.println("id : " + id);

        // id에 해당하는 게시물을 읽어온다.
        // id에 해당하는 게시물의 조회수도 1증가한다.

        return "board";
    }

    // 삭제한다. 관리자는 모든 글을 삭제할 수 있다.
    // 수정한다.

    // 로그인한 사용자가 글쓰기 GET
    @GetMapping("/writeForm")
    public String writeForm(){
        // 로그인한 사용자만 글을 써야한다.
        // 세션에서 로그인한 정보를 읽어들인다. 로그인을 하지 않았다면 리스트보기로 자동 이동 시킨다.

        return "writeForm";
    }

    // 로그인한 사용자가 글쓰기 POST
    @PostMapping("/write")
    public String write(
            @RequestParam("title") String title,
            @RequestParam("content") String content
    ){
        // 로그인한 사용자만 글을 써야한다.
        // 세션에서 로그인한 정보를 읽어들인다. 로그인을 하지 않았다면 리스트보기로 자동 이동 시킨다.
        System.out.println("title : " + title);
        // 로그인 한 회원 정보 + 제목, 내용을 저장한다.System.out.println("content : " + content);

        return "redirect:/"; // 리스트 보기로 리다이렉트한다.
    }
}
