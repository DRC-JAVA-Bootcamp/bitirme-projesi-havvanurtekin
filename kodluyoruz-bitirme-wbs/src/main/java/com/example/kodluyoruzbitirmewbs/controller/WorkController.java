package com.example.kodluyoruzbitirmewbs.controller;

import com.example.kodluyoruzbitirmewbs.responseDto.WorkResponseDto;
import com.example.kodluyoruzbitirmewbs.requestDto.WorkSaveRequestDto;
import com.example.kodluyoruzbitirmewbs.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//work controller
@RestController
@RequestMapping("/work")//istek atılacak path
public class WorkController {

    @Autowired
    WorkService workService;

    //yeni iş ekle
    @PostMapping("/saveWork")//istek atılacak path
    public ResponseEntity<Integer> saveWork(@RequestBody WorkSaveRequestDto workSaveRequestDto){
        Integer workId =  workService.saveWork(workSaveRequestDto);
        //response entitye 200 döndür
        return new ResponseEntity<>(workId, HttpStatus.OK);
    }

    //takım idsine göre tüm işleri listele
    @GetMapping("/findAllWorkByTeamId")//istek atılacak path
    public ResponseEntity<List<WorkResponseDto>> findAllWorkByTeamId(@RequestParam Integer teamId){

        List<WorkResponseDto> worksResponseDtoList = workService.findAllWorkByTeamId(teamId);
        //response entitye 200 döndür
        return new ResponseEntity<>(worksResponseDtoList, HttpStatus.OK);
    }

    //user id'ye göre tüm işleri listele
    @GetMapping("/findAllWorksByUserId")//istek atılacak path
    public ResponseEntity<List<WorkResponseDto>> findAllWorkByUserId(@RequestParam Integer userId){

        List<WorkResponseDto> worksResponseDtoList = workService.findAllWorkByUserId(userId);
        //response entitye 200 döndür
        return new ResponseEntity<>(worksResponseDtoList, HttpStatus.OK);
    }

    //work id'ye göre işi sil
    @DeleteMapping("/deleteWork")//istek atılacak path
    public ResponseEntity<Boolean> deleteWork(@RequestParam Integer workId){
        boolean deleteWork = workService.deleteWork(workId);
        //response entitye 200 döndür
        return new ResponseEntity<>(deleteWork, HttpStatus.OK);
    }
}
