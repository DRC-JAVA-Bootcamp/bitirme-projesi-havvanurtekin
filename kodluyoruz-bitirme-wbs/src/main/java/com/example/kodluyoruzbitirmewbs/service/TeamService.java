package com.example.kodluyoruzbitirmewbs.service;

import com.example.kodluyoruzbitirmewbs.entity.Team;
import com.example.kodluyoruzbitirmewbs.entity.User;
import com.example.kodluyoruzbitirmewbs.entity.UserRole;
import com.example.kodluyoruzbitirmewbs.repository.TeamRepository;
import com.example.kodluyoruzbitirmewbs.repository.UserRepository;
import com.example.kodluyoruzbitirmewbs.requestDto.TeamSaveRequestDto;
import com.example.kodluyoruzbitirmewbs.requestDto.UserSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    public int saveTeam(TeamSaveRequestDto teamSaveRequestDto) {

        int teamMemberCountRequestDto = teamSaveRequestDto.getMemberCount();
        User teamMemberRequestDto = teamSaveRequestDto.getUser();

        Team team = new Team();

        team.setMemberCount(teamMemberCountRequestDto);
        team.setUser(teamMemberRequestDto);

        return team.getId();
    }


}
