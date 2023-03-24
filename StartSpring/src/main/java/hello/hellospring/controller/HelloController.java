package hello.hellospring.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") // static의 index.html 에서 a태그에 /hello 라고 하면 여기로 오는 거임
    public String hello(Model model){ // 모델 만들어주고,
        model.addAttribute("data","hello!!ddddd");
        // -> 이름이 data인 변수의 값이 hello이다.-> templates의 data 값이 hello가 됨
        return "hello"; // hello.html 로 가서 렌더링 해라
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloStirng(@RequestParam("name") String name) {
        return "hello " + name; // "hello Spring"
    }

    @GetMapping("hello-api")
    @ResponseBody // 이게 없으면 viewResolver 한테 던지고 맞는 템플릿 돌려주는데,
    // 문자는 그냥 바로 주게 되는데, 객체로 했을 때는 기본방식인 json방식으로 만들어서 던짐
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    public static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
