package com.example.kodluyoruzbitirmewbs.util;

import com.example.kodluyoruzbitirmewbs.entity.Team;
import com.example.kodluyoruzbitirmewbs.entity.User;
import com.example.kodluyoruzbitirmewbs.entity.UserRole;
import com.example.kodluyoruzbitirmewbs.entity.Work;
import com.example.kodluyoruzbitirmewbs.repository.TeamRepository;
import com.example.kodluyoruzbitirmewbs.repository.UserRepository;
import com.example.kodluyoruzbitirmewbs.requestDto.TeamSaveRequestDto;
import com.example.kodluyoruzbitirmewbs.requestDto.UserSaveRequestDto;
import com.example.kodluyoruzbitirmewbs.requestDto.WorkSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConvertUtil {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TeamRepository teamRepository;

    //UserSaveRequestDto converter to User
    public User convertToUserFromUserRequestDto(UserSaveRequestDto userSaveRequestDto){
        String nameRequestDto = userSaveRequestDto.getName();
        String surnameRequestDto = userSaveRequestDto.getSurname();
        String emailRequestDto = userSaveRequestDto.getEmail();
        String passwordRequestDto = userSaveRequestDto.getPassword();
        UserRole roleRequestDto = userSaveRequestDto.getRole();
        Integer teamIdRequestDto = userSaveRequestDto.getTeamId();

        Team team = teamRepository.findById(teamIdRequestDto).get();
        User user = new User();

        user.setName(nameRequestDto);
        user.setSurname(surnameRequestDto);
        user.setEmail(emailRequestDto);
        user.setPassword(passwordRequestDto);
        user.setRole(roleRequestDto);
        user.setTeam(team);
        team.AddUser(user);
        return user;

    }

    //TeamSaveRequestDto converter to team
    public Team convertToTeamFromTeamRequestDTO(TeamSaveRequestDto teamSaveRequestDto){
        int teamMemberCountRequestDto = teamSaveRequestDto.getMemberCount();
        List<User> teamMemberRequestDto = teamSaveRequestDto.getUser();

        Team team = new Team();

        team.setMemberCount(teamMemberCountRequestDto);
        team.setUser(teamMemberRequestDto);

        return team;

    }

    //WorkSaveRequestDto converter to work
    public Work convertToWorkFromWorkRequestDTO(WorkSaveRequestDto workSaveRequestDto){
        String nameRequestDto = workSaveRequestDto.getWorkName();
        String commentRequestDto = workSaveRequestDto.getWorkComment();
        int parentRequestDto = workSaveRequestDto.getParentId();
        Integer userIdRequestDto = workSaveRequestDto.getUserId();

        User user = userRepository.findById(userIdRequestDto).get();
        Work work = new Work();

        work.setWorkName(nameRequestDto);
        work.setWorkComment(commentRequestDto);
        work.setParentId(parentRequestDto);
        work.setUser(user);
        return work;
    }
}
