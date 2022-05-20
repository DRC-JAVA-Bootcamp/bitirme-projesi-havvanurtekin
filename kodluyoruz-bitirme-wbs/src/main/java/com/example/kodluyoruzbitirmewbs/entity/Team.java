package com.example.kodluyoruzbitirmewbs.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

//team entity
@Entity
@Table
@Data
public class Team {

    //features
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


    //listeye user ekle
    public List<User> AddUser(User user){
        List<User> users = this.getUser();

        //takımın mevcunu kontrol et
        if(this.getMemberCount() < this.getMaxMemberCount()) {
            //bu user var mı
            if(!users.contains(user)){
                users.add(user);
                this.setMemberCount(this.getMemberCount() + 1);
            }
        }
        return users;
    }

    //listeden user sil
    public List<User> RemoveUser(User user) {
        List<User> users = this.getUser();
        //liste mevcudunu değiştir
        if (this.getMemberCount() > 0) {
            if (users.contains(user)) {
                users.remove(user);
                this.setMemberCount(this.getMemberCount() - 1);
            }
        }
        return users;
    }

}
