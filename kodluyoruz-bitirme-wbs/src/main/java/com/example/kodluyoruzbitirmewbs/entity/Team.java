package com.example.kodluyoruzbitirmewbs.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Team {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int maxMemberCount = 10;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int memberCount;

    @OneToMany
    @JoinColumn(name = "userId")
    private User user;

}
