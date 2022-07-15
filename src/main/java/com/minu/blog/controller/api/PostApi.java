package com.minu.blog.controller.api;

import com.minu.blog.entity.Post;
import com.minu.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/api/post" )
public class PostApi{

    private final PostService postService;

    @PostMapping( "/" )
    public ResponseEntity<String> save( @RequestBody Post post ){
        postService.save( post );
        return new ResponseEntity<>( "SUCCESS" , HttpStatus.OK );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<String> delete( @PathVariable Long id ){
        postService.deleteById( id );
        return new ResponseEntity<>( "SUCCESS" , HttpStatus.OK );
    }



}
