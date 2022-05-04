package com.example.kodluyoruzbitirmewbs.controller;

import com.example.kodluyoruzbitirmewbs.requestDto.UserSaveRequestDto;
import com.example.kodluyoruzbitirmewbs.requestDto.WorkSaveRequestDto;
import com.example.kodluyoruzbitirmewbs.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/work")
public class WorkController {

    @Autowired
    WorkService workService;

    @PostMapping("/saveWork")
    public void saveWork(@RequestBody WorkSaveRequestDto workSaveRequestDto){
        workService.saveWork(workSaveRequestDto);
    }
}
