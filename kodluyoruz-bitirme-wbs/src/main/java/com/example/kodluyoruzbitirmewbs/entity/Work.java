package com.example.kodluyoruzbitirmewbs.entity;


import lombok.Data;

import javax.persistence.*;


@Entity
@Table
@Data
public class Work {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(nullable = false)
    private String workName;
    @Column(nullable = false)
    private String workComment;
    @Column(nullable = false)
    private int parentId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

}
