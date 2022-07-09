package com.minu.blog.service;

import com.minu.blog.entity.Post;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

@RunWith( SpringRunner.class )
@SpringBootTest
@Transactional
public class PostListTest{

    @Autowired
    private PostService postService;

    /**
     * 여러개의 포스트 데이터를 미리 구현
     *
     * @author wumeenna
     */
    @BeforeEach
    public void set(){
        StringBuilder stringBuilder = new StringBuilder();
        for ( int i = 0; i < 1000; i++ ) {
            postService.save( Post.builder()
                    .title( stringBuilder
                            .append( "a" )
                            .append( i )
                            .append( i % 2 == 0 ? "search" : "" )
                            .toString() )
                    .content( "내용" ).build() );
            stringBuilder.setLength( 0 );
        }
    }

    @Test
    @DisplayName( "등록 내림차순 정렬 테스트" )
    public void descTest(){
        List<Post> posts = postService.findAll();
        assertEquals( 1000 , posts.size() );

        Post firstPost = posts.get( 0 );
    }

}
