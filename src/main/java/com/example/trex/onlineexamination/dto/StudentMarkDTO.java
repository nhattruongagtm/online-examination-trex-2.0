package com.example.trex.onlineexamination.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentMarkDTO {
    private long id;
    private String fullname;
    private int correct;
    private int total;
    private String createdDate;
    private double mark;

    public StudentMarkDTO(long id, String fullname, int correct, int total, String createdDate, double mark) {
        this.id = id;
        this.fullname = fullname;
        this.correct = correct;
        this.total = total;
        this.createdDate = createdDate;
        this.mark = mark;
    }
}
