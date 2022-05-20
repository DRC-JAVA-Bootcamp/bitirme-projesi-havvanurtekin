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
@RequestMapping("/user")//istek atılacak path
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")//istek atılacak path
    public ResponseEntity<Integer> saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto){
      //serviceten user kaydet ve idsini çek
      Integer userId =  userService.saveUser(userSaveRequestDto);
      //response entitye 200 döndür
      return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    //tüm takım üyelerini bul
    @GetMapping("/findAllUserByTeamId")//istek atılacak path
    public ResponseEntity<List<UserResponseDto>> findAllUsersByTeamId(@RequestParam Integer teamId){
        //takım id'ye göre serviceten userları döndür
        List<UserResponseDto> userResponseDtoList = userService.findAllUsersByTeamId(teamId);
        //response entitye 200 döndür
        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }

    //tüm kullanıcıları bul
    @GetMapping("/findAllUser")//istek atılacak path
    public ResponseEntity<List<UserResponseDto>> findAllUser(){
        //servisten tüm kullanıcıları liste olarak çek
        List<UserResponseDto> userResponseDtoList = userService.findAllUser();
        //response entitye 200 döndür
        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }

    //idsine göre takımdan kullanıcı sil
    @DeleteMapping("/deleteUserByIdFromTeam")//istek atılacak path
    public ResponseEntity<Boolean> deleteUserByIdFromTeam(@RequestParam Integer userId){
        //kullanıcı sil eğer silinirse true döndür
        boolean deleteUser = userService.deleteUserByIdFromTeam(userId);
        //response entitye 200 döndür
        return new ResponseEntity<>(deleteUser, HttpStatus.OK);
    }
}
