package com.example.kodluyoruzbitirmewbs.requestDto;

import com.example.kodluyoruzbitirmewbs.entity.User;
import lombok.Data;

//work save request dto
@Data
public class WorkSaveRequestDto {

    private String workName;

    private String workComment;

    private int parentId;


    private Integer userId;
}
