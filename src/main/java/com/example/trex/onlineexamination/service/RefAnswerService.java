package com.example.trex.onlineexamination.service;

import com.example.trex.onlineexamination.model.RefAnswer;
import com.example.trex.onlineexamination.model.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface RefAnswerService {
    RefAnswer saveTest(RefAnswer answer);

    ResponseEntity<ResponseObject> saveMark(RefAnswer rs);

    ResponseEntity<ResponseObject> getMarksByStudent(Long studentId);

    ResponseEntity<ResponseObject> getMarkByStudent(Long studentId, Long examId);
}
