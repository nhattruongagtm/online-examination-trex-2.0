package com.example.trex.onlineexamination.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerRequest {
    private Long studentId;
    private Long subjectId;
    private Integer duration;
    private Date examDate;
    private List<com.example.trex.dto.ChoosedRequest> answers;
}
