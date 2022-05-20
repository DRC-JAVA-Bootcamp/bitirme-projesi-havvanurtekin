package com.example.kodluyoruzbitirmewbs.responseDto;

import lombok.Data;
//work response dto
@Data
public class WorkResponseDto {
    private String workName;

    private String workComment;

    private int parentId;

    private Integer userId;
}
