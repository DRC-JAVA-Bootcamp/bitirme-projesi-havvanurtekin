package com.example.kodluyoruzbitirmewbs.responseDto;

import com.example.kodluyoruzbitirmewbs.entity.UserRole;
import lombok.Data;
//user response dto
@Data
public class UserResponseDto {

    private String name;

    private String surname;

    private String email;

    private UserRole role;
}
