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
    @Column
    private String workName;
    @Column
    private String workComment;
    @Column
    private int parentId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

}
