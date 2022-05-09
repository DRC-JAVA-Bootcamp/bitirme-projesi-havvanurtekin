package com.example.kodluyoruzbitirmewbs.controller;

import com.example.kodluyoruzbitirmewbs.requestDto.TeamSaveRequestDto;

import com.example.kodluyoruzbitirmewbs.requestDto.UserSaveRequestDto;
import com.example.kodluyoruzbitirmewbs.responseDto.TeamResponseDto;
import com.example.kodluyoruzbitirmewbs.service.TeamService;

import com.example.kodluyoruzbitirmewbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/team")
public class TeamController {

        @Autowired
        TeamService teamService;

        @Autowired
        UserService userService;

        @PostMapping("/saveTeam")
        public ResponseEntity<Integer> saveTeam(@RequestBody TeamSaveRequestDto teamSaveRequestDto){
            Integer teamId =  teamService.saveTeam(teamSaveRequestDto);
            return new ResponseEntity<>(teamId, HttpStatus.OK);
        }

        @GetMapping("/findAllTeams")
        public ResponseEntity<List<TeamResponseDto>> findAllTeams(){

            List<TeamResponseDto> teamResponseDtos = teamService.findAllTeam();
            return new ResponseEntity<>(teamResponseDtos, HttpStatus.OK);
        }

        @DeleteMapping("/deleteTeamById")
        public ResponseEntity<Boolean> deleteTeamById(@RequestParam Integer teamId){
            boolean deleteTeam = teamService.deleteTeamById(teamId);
            return new ResponseEntity<>(deleteTeam, HttpStatus.OK);
        }


}


