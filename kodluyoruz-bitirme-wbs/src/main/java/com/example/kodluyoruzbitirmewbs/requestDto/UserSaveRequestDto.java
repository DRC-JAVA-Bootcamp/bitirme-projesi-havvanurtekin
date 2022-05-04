package com.example.kodluyoruzbitirmewbs.requestDto;

import com.example.kodluyoruzbitirmewbs.entity.Team;
import com.example.kodluyoruzbitirmewbs.entity.UserRole;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class UserSaveRequestDto {
    private String name;

    private String surname;

    private String email;

    private String password;

    private UserRole role;

    private Team team;

}
