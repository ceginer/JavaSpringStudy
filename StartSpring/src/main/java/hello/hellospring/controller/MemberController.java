package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/*Controller의 경우 컴포넌트 스캔 방식으로만 스프링에 올라감 */
@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


/*  ***컴포넌트 스캔 방식***
    //final 변수인 memberService를 스프링이 파라미터인 memberService와 연결시켜줌
    //---
    //Autowired 스프링 컨테이너에서 memberService를 가져옴
    //memberService는 순수 자바 클래스임. 스프링이 알 수 있는 방법이 없음
    //MemberService 클래스에 들어가서 @Service 입력
    //MemoryMemberRepository에 @Repository 입력
    //controller-service-repository 연결
 */

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    /*
    <form action="/members/new" ></form> 을 통해서 @PostMapping 으로 들어오면서
    create 메서드를 실행하게 되고, create 메서드는 매개변수인 MemberForm form 을 자동적으로 받아들이게 된다.
    그럼으로써 밑의 함수들이 계속 실행되고 return 에서 redirect 되면서 홈화면으로 돌아가게 된다.
     */
    @PostMapping(value = "/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    /*
    여기서 또 GetMapping 해주니깐 매개변수에는 Model model 이 필요함
    Model 에 변수를 담아서 템플릿으로 넘길 거임 -> model.addAttribute(넘어갈 때 변수 이름, 넘어갈 데이터)
     */
    @GetMapping(value =  "/members")
    public String list(Model model) { // 여기 Model은 import에서 spring.framework 걸로 해야됨.
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        // -----> 여기서 members 라는 것을 받아서 Model에 한 번에 담아서 템플릿에 넘길 거임.
        return "members/memberList";

    }
}
