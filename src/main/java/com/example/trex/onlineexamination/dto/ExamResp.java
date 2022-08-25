package com.example.trex.onlineexamination.dto;

import com.example.trex.model.RefAnswer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExamResp {
    private Long id;
    private List<RefAnswer> refExams;
}
