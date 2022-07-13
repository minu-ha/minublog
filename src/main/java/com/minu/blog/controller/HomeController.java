package com.minu.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController{

    @GetMapping( "/" )
    public String index(){
        return "index";
    }

    @GetMapping( "/post" )
    public String post(){
        return "pages/post";
    }

    @GetMapping( "/about" )
    public String about(){
        return "pages/about";
    }
}
