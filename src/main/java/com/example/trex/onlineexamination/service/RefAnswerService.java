package com.example.trex.onlineexamination.service;

import com.example.trex.onlineexamination.model.RefAnswer;
import com.example.trex.onlineexamination.model.ResponseObject;
import com.example.trex.onlineexamination.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RefAnswerService {
    RefAnswer saveTest(RefAnswer answer);

    List<RefAnswer> findByStudentId();
//
//    ResponseEntity<ResponseObject> saveMark(RefAnswer rs);
//
//    ResponseEntity<ResponseObject> getMarksByStudent(Long studentId);
//
//    ResponseEntity<ResponseObject> getMarkByStudent(Long studentId, Long examId);
}
