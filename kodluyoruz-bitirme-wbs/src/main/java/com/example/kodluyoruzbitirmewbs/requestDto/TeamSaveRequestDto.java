package com.example.kodluyoruzbitirmewbs.requestDto;

import com.example.kodluyoruzbitirmewbs.entity.User;
import lombok.Data;

import java.util.List;

//team save request dto
@Data
public class TeamSaveRequestDto {

    private int memberCount;

    private List<User> user;
}
