package com.example.kodluyoruzbitirmewbs.controller;

import com.example.kodluyoruzbitirmewbs.requestDto.TeamSaveRequestDto;
import com.example.kodluyoruzbitirmewbs.responseDto.TeamResponseDto;
import com.example.kodluyoruzbitirmewbs.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//team controller
@RestController
@RequestMapping("/team")//istek atılacak path
public class TeamController {

        @Autowired
        TeamService teamService;

        //yeni takım ekle - post ile
        @PostMapping("/saveTeam")//istek atılacak path
        public ResponseEntity<Integer> saveTeam(@RequestBody TeamSaveRequestDto teamSaveRequestDto){
            //serviceten takım id çek
            Integer teamId =  teamService.saveTeam(teamSaveRequestDto);
            //response entitye 200 döndür
            return new ResponseEntity<>(teamId, HttpStatus.OK);
        }

        //takımların hepsini ara ve bul
        @GetMapping("/findAllTeams")//istek atılacak path
        public ResponseEntity<List<TeamResponseDto>> findAllTeams(){
            //serviceten takımları liste olarak çek
            List<TeamResponseDto> teamResponseDtos = teamService.findAllTeam();
            //response entitye 200 döndür
            return new ResponseEntity<>(teamResponseDtos, HttpStatus.OK);
        }
        //takımı sil
        @DeleteMapping("/deleteTeamById")//istek atılacak path
        public ResponseEntity<Boolean> deleteTeamById(@RequestParam Integer teamId){
            //takım silindiyse serviceten true döndür
            boolean deleteTeam = teamService.deleteTeamById(teamId);
            //response entitye 200 döndür
            return new ResponseEntity<>(deleteTeam, HttpStatus.OK);
        }


}


