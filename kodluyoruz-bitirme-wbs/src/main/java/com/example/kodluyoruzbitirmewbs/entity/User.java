package com.example.kodluyoruzbitirmewbs.entity;

import lombok.Data;

import javax.persistence.*;

//User entity
@Entity
@Data
@Table
public class User {

    //features
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UserRole role;

    @ManyToOne
    @JoinColumn(name = "teamId",nullable = false)
    private Team team;

}
