package com.example.kodluyoruzbitirmewbs.service;

import com.example.kodluyoruzbitirmewbs.entity.User;
import com.example.kodluyoruzbitirmewbs.entity.Work;
import com.example.kodluyoruzbitirmewbs.repository.WorkRepository;
import com.example.kodluyoruzbitirmewbs.requestDto.WorkSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkService {
    @Autowired
    WorkRepository workRepository;

    public void saveWork(WorkSaveRequestDto workSaveRequestDto){
        String nameRequestDto = workSaveRequestDto.getWorkName();
        String commentRequestDto = workSaveRequestDto.getWorkComment();
        int parentRequestDto = workSaveRequestDto.getParentId();
        User userRequestDto = workSaveRequestDto.getUser();

        Work work = new Work();

        work.setWorkName(nameRequestDto);
        work.setWorkComment(commentRequestDto);
        work.setParentId(parentRequestDto);
        work.setUser(userRequestDto);

        work = workRepository.save(work);

    }
}
