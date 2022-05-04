package com.example.kodluyoruzbitirmewbs.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String password;

    @ManyToOne
    @JoinColumn
    private UserRole role;

    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team team;

}
