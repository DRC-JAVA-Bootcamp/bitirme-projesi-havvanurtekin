package com.example.kodluyoruzbitirmewbs.requestDto;

import com.example.kodluyoruzbitirmewbs.entity.User;
import lombok.Data;


@Data
public class TeamSaveRequestDto {

    private int memberCount;

    private User user;
}
