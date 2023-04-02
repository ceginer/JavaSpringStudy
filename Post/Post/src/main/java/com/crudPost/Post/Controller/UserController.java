package com.crudPost.Post.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @GetMapping("/userRegForm")
    public String userRegForm(){
        return "userRegForm";
    }

    @PostMapping("/userReg")
    public String userReg(
            // post 방식의 파람들 받아오기
            @RequestParam("name") String name,
            @RequestParam("email")String email,
            @RequestParam("password")String password){
        return "redirect:/";
    }

}
