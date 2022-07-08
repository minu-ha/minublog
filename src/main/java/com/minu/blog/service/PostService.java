package com.minu.blog.service;

import com.minu.blog.entity.Post;
import com.minu.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostService{

    @Autowired
    PostRepository postRepository;

    public Post save( Post post ){
        return postRepository.save( post );
    }

    public List<Post> findBoards(){
        return Collections.unmodifiableList( postRepository.findAll() );
    }

    public void delete( Long id ){
        postRepository.deleteById( id );
    }
}
