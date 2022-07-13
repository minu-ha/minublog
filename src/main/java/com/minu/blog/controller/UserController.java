package com.minu.blog.controller;

import com.minu.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController{

    private final UserService userService;

    @GetMapping("/join")
    public String joinForm(){
        return "pages/join";
    }
    @GetMapping("/login")
    public String loginForm(){
        return "pages/login";
    }

}
