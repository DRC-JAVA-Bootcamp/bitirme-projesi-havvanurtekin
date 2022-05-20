package com.example.kodluyoruzbitirmewbs.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Team {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private int maxMemberCount = 10;

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int memberCount;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<User> user;


    public List<User> AddUser(User user){
        List<User> users = this.getUser();

        if(this.getMemberCount() < this.getMaxMemberCount()) {
            if(!users.contains(user)){
                users.add(user);
                this.setMemberCount(this.getMemberCount() + 1);
            }
        }
        return users;
    }

    public List<User> RemoveUser(User user) {
        List<User> users = this.getUser();
        if (this.getMemberCount() > 0) {
            if (users.contains(user)) {
                users.remove(user);
                this.setMemberCount(this.getMemberCount() - 1);
            }
        }
        return users;
    }

}
