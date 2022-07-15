package com.minu.blog.service;

import com.minu.blog.entity.Post;
import com.minu.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService{

    private final PostRepository postRepository;

    /**
     * 게시글 저장
     */
    public void save( Post post ){
        postRepository.save( post );
    }

    /**
     * 글목록
     */
    public Page<Post> posts( Pageable pageable ){
        return postRepository.findAll( pageable );
    }


    /**
     * 게시글 ID로 조회
     */
    public Post findById( Long id ){
        return postRepository.findById( id ).orElse( new Post() );
    }

    /**
     * 게시글 삭제
     */
    public void deleteById( Long id ){
        postRepository.deleteById( id );
    }


    public List<Post> findAll(){
        return postRepository.findAll();
    }
}
