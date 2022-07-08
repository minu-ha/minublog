package com.minu.blog.controller;

import com.minu.blog.entity.Post;
import com.minu.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/board" )
public class PostController{

    @Autowired
    PostService postService;

    @GetMapping( "" )
    public List<Post> list(){
        return postService.findBoards();
    }


    @PostMapping( "" )
    public Post board( @RequestBody Post post ){
        return postService.save( post );
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Long id ){
        postService.delete( id );
    }
}
