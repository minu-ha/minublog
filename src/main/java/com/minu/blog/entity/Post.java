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
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Lob
    @Column
    private String content;

    @Column
    private String writer;

    @Column
    @CreationTimestamp
    private LocalDateTime createDate;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime updateDate;

}

