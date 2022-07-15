package com.minu.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @Column( nullable = false )
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

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "USER_ID" )
    private User user;

    @OneToMany( mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE )
    @JsonIgnoreProperties( { "post" } )
    @OrderBy( "id desc " )
    private List<Reply> replies;


    public void update( Post post ){
        this.title = post.title;
        this.content = post.content;
        this.writer = post.writer;
    }

    public void delete( Post post ){

    }
}

