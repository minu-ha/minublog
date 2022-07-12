package com.minu.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String content;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "POST_ID" )
    private Post post;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "USER_ID" )
    private User user;



}

