package com.example.kodluyoruzbitirmewbs.controller;

import com.example.kodluyoruzbitirmewbs.responseDto.WorkResponseDto;
import com.example.kodluyoruzbitirmewbs.requestDto.WorkSaveRequestDto;
import com.example.kodluyoruzbitirmewbs.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/work")
public class WorkController {

    @Autowired
    WorkService workService;

    @PostMapping("/saveWork")
    public ResponseEntity<Integer> saveWork(@RequestBody WorkSaveRequestDto workSaveRequestDto){
        Integer workId =  workService.saveWork(workSaveRequestDto);
        return new ResponseEntity<>(workId, HttpStatus.OK);
    }

    @GetMapping("/findAllWorkByTeamId")
    public ResponseEntity<List<WorkResponseDto>> findAllWorkByTeamId(@RequestParam Integer teamId){

        List<WorkResponseDto> worksResponseDtoList = workService.findAllWorkByTeamId(teamId);
        return new ResponseEntity<>(worksResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/findAllWorksByUserId")
    public ResponseEntity<List<WorkResponseDto>> findAllWorkByUserId(@RequestParam Integer userId){

        List<WorkResponseDto> worksResponseDtoList = workService.findAllWorkByUserId(userId);
        return new ResponseEntity<>(worksResponseDtoList, HttpStatus.OK);
    }

    @DeleteMapping("/deleteWork")
    public ResponseEntity<Boolean> deleteWork(@RequestParam Integer workId){
        boolean deleteWork = workService.deleteWork(workId);
        return new ResponseEntity<>(deleteWork, HttpStatus.OK);
    }
}
