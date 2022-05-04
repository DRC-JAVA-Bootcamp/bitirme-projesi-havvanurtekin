package com.example.kodluyoruzbitirmewbs.controller;

import com.example.kodluyoruzbitirmewbs.requestDto.TeamSaveRequestDto;

import com.example.kodluyoruzbitirmewbs.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/team")
public class TeamController {

        @Autowired
        TeamService teamService;

        @PostMapping("/saveTeam")
        public ResponseEntity<Integer> saveTeam(@RequestBody TeamSaveRequestDto teamSaveRequestDto){
            Integer teamId =  teamService.saveTeam(teamSaveRequestDto);
            return new ResponseEntity<>(teamId, HttpStatus.OK);
        }
}


