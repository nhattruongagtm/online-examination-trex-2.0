package com.example.trex.onlineexamination.service.impl;

import com.example.trex.onlineexamination.model.Exam;
import com.example.trex.onlineexamination.model.RefAnswer;
import com.example.trex.onlineexamination.model.ResponseObject;
import com.example.trex.onlineexamination.repository.ExamRepo;
import com.example.trex.onlineexamination.repository.RefAnswerRepo;
import com.example.trex.onlineexamination.service.RefAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RefAnswerServiceImpl implements RefAnswerService {

    @Autowired
    private RefAnswerRepo answerRepository;

    @Autowired
    private ExamRepo examRepository;

    @Override
    public RefAnswer saveTest(RefAnswer answer) {
        List<RefAnswer> isTested = answerRepository.findAllByExamIdAndStudentId(answer.getExam().getId(),answer.getStudent().getId());

        if(isTested.size() > 0){
            return null;
        }
        answer.setCreatedDate(new Date());
        RefAnswer res = answerRepository.save(answer);
        Exam exam = examRepository.findById(answer.getExam().getId()).get();
        res.setExam(exam);
        answer.setLastCorrect(res.correct());
        answerRepository.save(answer);

        return res;
    }


//    @Override
//    public ResponseEntity<ResponseObject> saveMark(RefAnswer rs) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<ResponseObject> getMarksByStudent(Long studentId) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<ResponseObject> getMarkByStudent(Long studentId, Long examId) {
//        return null;
//    }


}
