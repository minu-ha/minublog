package com.minu.blog.service;

import com.minu.blog.entity.User;
import com.minu.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;

    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public void save( User user ){
        userRepository.save( user );
    }

    public User login( User user ){
        return userRepository.findByNameAndPassword( user.getName() , user.getPassword() );
    }

}
