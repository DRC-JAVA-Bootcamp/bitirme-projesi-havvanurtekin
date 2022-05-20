package com.example.kodluyoruzbitirmewbs.requestDto;


import com.example.kodluyoruzbitirmewbs.entity.UserRole;
import lombok.Data;
//user save request dto
@Data
public class UserSaveRequestDto {
    private String name;

    private String surname;

    private String email;

    private String password;

    private UserRole role;

    private Integer teamId;

}
