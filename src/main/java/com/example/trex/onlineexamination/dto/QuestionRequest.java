package com.example.trex.onlineexamination.dto;

import com.example.trex.onlineexamination.model.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequest {
    private Long subjectID;
    private Long teacherID;
    private Time time;
    private Date date;
    private int duration;
    private String name;
    private Date createdDate;
    private String dateTime;
    private List<Question> listQuestions;
    private Long id;
}
