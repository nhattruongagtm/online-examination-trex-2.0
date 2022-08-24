package com.example.trex.onlineexamination.service;

import com.example.trex.onlineexamination.dto.ExamDTO;
import com.example.trex.onlineexamination.model.Exam;

import java.util.List;

public interface ExamService {
    Exam createExam(Exam exam);

    Exam updateExam(Exam exam);

    void deleteExam(Long id);

    boolean checkTestPermission(Long id, Long examID);

    Exam getExam();

    List<Exam> getListExam(Long id);

    Exam loadExam(String code);

    Exam loadExamBySubject(Long subjectId);

    List<ExamDTO> getExamListByStudentID(Long id);

    boolean isTest(Long uid, Long eid);

    Exam editExam(Long id, Exam exam);
}
