package com.minu.blog.controller.api;

import com.minu.blog.entity.User;
import com.minu.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping( "/api" )
@RequiredArgsConstructor
public class UserApi{

    private final UserService userService;

    @PostMapping( "/user" )
    public ResponseEntity<String> save( @RequestBody User user ){
        userService.save( user );
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK );
    }

}
