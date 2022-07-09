package com.minu.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User{

    @Id
    @Column
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;
}
