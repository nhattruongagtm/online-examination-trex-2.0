package com.example.trex.onlineexamination.service;

import com.example.trex.onlineexamination.model.Subject;

import java.util.List;

public interface SemesterService {
    List<Subject> getSubjectBySemester(int semester, int year);
}
