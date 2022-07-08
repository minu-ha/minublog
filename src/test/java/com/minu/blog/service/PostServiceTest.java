package com.minu.blog.service;

import com.minu.blog.entity.Post;
import com.minu.blog.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith( SpringRunner.class )
@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class PostServiceTest{

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @BeforeEach
    public void set(){
        postRepository.save( Post.builder()
                .title( "안녕하세요" )
                .build() );

    }

    @Test
    public void 전체데이터가져오기(){
        assertFalse( postRepository.findAll().isEmpty() );
    }



}