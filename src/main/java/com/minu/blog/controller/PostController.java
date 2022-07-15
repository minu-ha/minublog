package com.minu.blog.controller;

import com.minu.blog.entity.Post;
import com.minu.blog.repository.PostRepository;
import com.minu.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/post" )
public class PostController{

    @GetMapping( "/create" )
    public String createPost(){
        return "pages/createPost";
    }
}
