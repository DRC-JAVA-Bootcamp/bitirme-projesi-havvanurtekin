package com.example.kodluyoruzbitirmewbs.service;

import com.example.kodluyoruzbitirmewbs.entity.Team;
import com.example.kodluyoruzbitirmewbs.entity.User;
import com.example.kodluyoruzbitirmewbs.entity.Work;
import com.example.kodluyoruzbitirmewbs.repository.TeamRepository;
import com.example.kodluyoruzbitirmewbs.repository.UserRepository;
import com.example.kodluyoruzbitirmewbs.repository.WorkRepository;
import com.example.kodluyoruzbitirmewbs.responseDto.WorkResponseDto;
import com.example.kodluyoruzbitirmewbs.requestDto.WorkSaveRequestDto;
import com.example.kodluyoruzbitirmewbs.util.ConvertUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//work service
@Service
public class WorkService {
    @Autowired
    WorkRepository workRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ConvertUtil convertUtil;

    //model mapper
    ModelMapper modelMapper = new ModelMapper();



    //yeni iş ekle id döndür
    public int saveWork(WorkSaveRequestDto workSaveRequestDto){
        Work work = convertUtil.convertToWorkFromWorkRequestDTO(workSaveRequestDto);
        work = workRepository.save(work);
        return work.getId();

    }

    //takım idsine göre takımın yaptığı tüm işleri döndür listele
    public List<WorkResponseDto> findAllWorkByTeamId(Integer teamId) {

        Team team = teamRepository.findById(teamId).get();
        List<Work> workList = workRepository.findAllByTeam(team);
        List<WorkResponseDto> workResponseDtos = new ArrayList<>();
        for(Work work : workList){
            WorkResponseDto workResponseDto = modelMapper.map(work, WorkResponseDto.class);
            workResponseDtos.add(workResponseDto);
        }
        return workResponseDtos;
    }

    //user id ye göre yapılan işleri listele
    public List<WorkResponseDto> findAllWorkByUserId(Integer userId) {
        User user = userRepository.findById(userId).get();
        List<Work> workList = workRepository.findAllByUser(user);
        List<WorkResponseDto> workResponseDtos = new ArrayList<>();
        for(Work work : workList){
            WorkResponseDto workResponseDto = modelMapper.map(work, WorkResponseDto.class);
            workResponseDtos.add(workResponseDto);
        }
        return workResponseDtos;

    }

    //işi idsine göre sil silinince true döndür
    public boolean deleteWork(Integer workId) {
        Work work = workRepository.findById(workId).get();
        List<Work> workList = workRepository.findAllById(workId);
        for(Work w : workList){
            if(work.getId() == w.getParentId()){
               workList.remove(work);
            }
        }
        workRepository.delete(work);
        return true;
    }
}
