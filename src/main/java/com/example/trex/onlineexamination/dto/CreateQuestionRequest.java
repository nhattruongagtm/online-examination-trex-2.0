package com.example.trex.onlineexamination.dto;

import com.example.trex.onlineexamination.model.Answer;
import com.example.trex.onlineexamination.model.Exam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateQuestionRequest {
    private String title;
    private String correct;
    private List<Answer> answers;
    private Exam exam;


}
