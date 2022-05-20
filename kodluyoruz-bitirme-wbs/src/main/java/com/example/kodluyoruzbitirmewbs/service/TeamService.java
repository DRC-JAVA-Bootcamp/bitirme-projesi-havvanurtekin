package com.example.kodluyoruzbitirmewbs.service;

import com.example.kodluyoruzbitirmewbs.entity.Team;
import com.example.kodluyoruzbitirmewbs.entity.User;
import com.example.kodluyoruzbitirmewbs.entity.UserRole;
import com.example.kodluyoruzbitirmewbs.entity.Work;
import com.example.kodluyoruzbitirmewbs.repository.TeamRepository;
import com.example.kodluyoruzbitirmewbs.repository.UserRepository;
import com.example.kodluyoruzbitirmewbs.requestDto.TeamSaveRequestDto;
import com.example.kodluyoruzbitirmewbs.requestDto.UserSaveRequestDto;
import com.example.kodluyoruzbitirmewbs.responseDto.TeamResponseDto;
import com.example.kodluyoruzbitirmewbs.responseDto.UserResponseDto;
import com.example.kodluyoruzbitirmewbs.util.ConvertUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//team service
@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    ConvertUtil convertUtil;

    @Autowired
    ModelMapper modelMapper;

    //takımı ekle id döndür
    public int saveTeam(TeamSaveRequestDto teamSaveRequestDto) {

       Team team = convertUtil.convertToTeamFromTeamRequestDTO(teamSaveRequestDto);
       team = teamRepository.save(team);
       return team.getId();
    }


    //takımların hepsini listele ve listeyi döndür
    public List<TeamResponseDto> findAllTeam() {
        Iterable<Team> teamList = teamRepository.findAll();
        List<TeamResponseDto> teamResponseDtos = new ArrayList<>();
        for(Team team : teamList){
            TeamResponseDto teamResponseDto = modelMapper.map(team, TeamResponseDto.class);
            teamResponseDtos.add(teamResponseDto);
        }
        return teamResponseDtos;
    }

    //takımı idsine göre sil
    public boolean deleteTeamById(Integer teamId) {
        Team team = teamRepository.findById(teamId).get();
        teamRepository.delete(team);
        return true;
    }


}
