package com.example.trex.onlineexamination.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResultResponse {
    private Long examId;

    private String subjectName;

    private int correct;

    private int total;

    private Date createdDate;
}
