package com.example.kodluyoruzbitirmewbs.controller;

import com.example.kodluyoruzbitirmewbs.requestDto.UserSaveRequestDto;
import com.example.kodluyoruzbitirmewbs.responseDto.UserResponseDto;
import com.example.kodluyoruzbitirmewbs.responseDto.WorkResponseDto;
import com.example.kodluyoruzbitirmewbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<Integer> saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto){
      Integer userId =  userService.saveUser(userSaveRequestDto);
      return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    @GetMapping("/findAllUserByTeamId")
    public ResponseEntity<List<UserResponseDto>> findAllUsersByTeamId(@RequestParam Integer teamId){

        List<UserResponseDto> userResponseDtoList = userService.findAllUsersByTeamId(teamId);
        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }


    @GetMapping("/findAllUser")
    public ResponseEntity<List<UserResponseDto>> findAllUser(){

        List<UserResponseDto> userResponseDtoList = userService.findAllUser();
        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }


    @DeleteMapping("/deleteUserByIdFromTeam")
    public ResponseEntity<Boolean> deleteUserByIdFromTeam(@RequestParam Integer userId){
        boolean deleteUser = userService.deleteUserByIdFromTeam(userId);
        return new ResponseEntity<>(deleteUser, HttpStatus.OK);
    }
}
