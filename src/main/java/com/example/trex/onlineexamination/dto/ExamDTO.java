package com.example.trex.onlineexamination.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ExamDTO {
    private Long id;
    private Long subjectID;
    private Date date;
    private Time time;
    private int duration;
    private String subjectName;
    private String code;
}
