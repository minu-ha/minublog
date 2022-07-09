package com.minu.blog.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post{

    @Id
    @Column
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column
    private String title;

    @Lob
    @Column
    private String content;

    @Column
    private String writer;

    @Column( updatable = false )
    @CreationTimestamp
    private LocalDateTime createDate;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime updateDate;

    public void update( Post post ){
        this.title = post.title;
        this.content = post.content;
        this.writer = post.writer;
    }

    public void delete( Post post ){

    }
}

