package com.example.kodluyoruzbitirmewbs.service;

import com.example.kodluyoruzbitirmewbs.entity.Team;
import com.example.kodluyoruzbitirmewbs.entity.User;
import com.example.kodluyoruzbitirmewbs.repository.TeamRepository;
import com.example.kodluyoruzbitirmewbs.repository.UserRepository;
import com.example.kodluyoruzbitirmewbs.requestDto.UserSaveRequestDto;
import com.example.kodluyoruzbitirmewbs.responseDto.UserResponseDto;
import com.example.kodluyoruzbitirmewbs.util.ConvertUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    ConvertUtil convertUtil;

    @Autowired
    ModelMapper modelMapper;

    public int saveUser(UserSaveRequestDto userSaveRequestDto) {
        User user = convertUtil.convertToUserFromUserRequestDto(userSaveRequestDto);
        user = userRepository.save(user);

        return user.getId();
    }

    public List<UserResponseDto> findAllUsersByTeamId(Integer teamId) {
        Team team = teamRepository.findById(teamId).get();
        List<User> userList = userRepository.findAllByTeam(team);
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for(User user : userList){
            UserResponseDto userResponseDto = modelMapper.map(user, UserResponseDto.class);
            userResponseDtos.add(userResponseDto);
        }
        return userResponseDtos;
    }

    public boolean deleteUserByIdFromTeam(Integer userId) {
        User user = userRepository.findById(userId).get();
        Integer teamId = user.getTeam().getId();
        Team team = teamRepository.findById(teamId).get();
        team.RemoveUser(user);
        userRepository.delete(user);
        return true;
    }

    public List<UserResponseDto> findAllUser() {
        Iterable<User> userList = userRepository.findAll();
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for(User user : userList){
            UserResponseDto userResponseDto = modelMapper.map(user, UserResponseDto.class);
            userResponseDtos.add(userResponseDto);
        }
        return userResponseDtos;
    }
}
