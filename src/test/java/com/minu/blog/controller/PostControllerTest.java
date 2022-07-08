package com.minu.blog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.minu.blog.entity.Post;
import com.minu.blog.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith( SpringRunner.class )
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest{

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PostService postService;
    private ObjectMapper objectMapper;

    @Before
    public void setup(){
        assertNotNull( postService );
        objectMapper = new ObjectMapper();
        objectMapper.configure( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS , false );
        objectMapper.registerModule( new JavaTimeModule() );
    }

    @Test
    public void test() throws Exception{

        //쓰기 테스트
        this.mvc.perform( MockMvcRequestBuilders.post( "/board" )
                        .content( objectMapper.writeValueAsString(
                                Post.builder().title( "제목" ).content( "내용" ).build() ) )
                        .contentType( MediaType.parseMediaType( MediaType.APPLICATION_JSON_VALUE ) ) )
                .andExpect( content().contentType(
                        MediaType.parseMediaType( MediaType.APPLICATION_JSON_VALUE ) ) )
                .andExpect( status().isOk() );

        List<Post> posts = postService.findBoards();

        //목록 테스트
        this.mvc.perform( MockMvcRequestBuilders.get( "/board" ) )
                .andExpect( content().contentType(
                        MediaType.parseMediaType( MediaType.APPLICATION_JSON_VALUE ) ) )
                .andExpect( content().json( objectMapper.writeValueAsString( posts ) ) )
                .andExpect( status().isOk() );

        Post post = postService.findOne(1L);

        //보기 테스트
        this.mvc.perform( MockMvcRequestBuilders.get( "/board/{boardId}" , 1 ) )
                .andExpect( content().contentType(
                        MediaType.parseMediaType( MediaType.APPLICATION_JSON_VALUE ) ) )
                .andExpect( content().json( objectMapper.writeValueAsString( post ) ) )
                .andExpect( status().isOk() );

        this.mvc.perform( MockMvcRequestBuilders.delete( "/board/{boardId}" , 1 ) )
                .andExpect( status().isOk() );

        assertTrue( postService.findBoards().isEmpty() );
    }

}