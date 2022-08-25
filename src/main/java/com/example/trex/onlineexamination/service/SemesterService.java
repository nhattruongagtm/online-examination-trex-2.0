package com.example.trex.onlineexamination.service;

import com.example.trex.onlineexamination.dto.ListResp;
import com.example.trex.onlineexamination.dto.SemesterDTO;
import com.example.trex.onlineexamination.model.Semester;
import com.example.trex.onlineexamination.model.Subject;

import java.util.List;

public interface SemesterService {
    ListResp<Semester> getSubjectsBySemester(int page, int limit, int semester, int year);

}
