package com.minu.blog.controller;

import com.minu.blog.entity.Post;
import com.minu.blog.repository.PostRepository;
import com.minu.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/api/post" )
public class PostController{

    private final PostService postService;

    private final PostRepository postRepository;

    @GetMapping( "" )
    public List<Post> Posts(){
        return postService.findAll();
    }

    @PostMapping( "" )
    public void create( @RequestBody Post post ){
        postService.save( post );
    }

    @GetMapping( "/{id}" )
    public Post select( @PathVariable Long id ){
        return postService.findById( id );
    }

    @PutMapping( "/{id}" )
    public Post update( @PathVariable Long id ){
        Post post = postService.findById( id );
        post.update( post );
        return post;
    }

    @DeleteMapping( "/{id}" )
    public Post delete( @PathVariable Long id ){
        Post post = postService.findById( id );
        post.delete( post );
        return post;
    }

}