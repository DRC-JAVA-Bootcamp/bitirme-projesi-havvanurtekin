package com.example.kodluyoruzbitirmewbs.responseDto;

import com.example.kodluyoruzbitirmewbs.entity.User;
import lombok.Data;

import java.util.List;
//team response dto
@Data
public class TeamResponseDto {
    private int maxMemberCount = 10;

    private int memberCount;

    private List<User> user;
}
