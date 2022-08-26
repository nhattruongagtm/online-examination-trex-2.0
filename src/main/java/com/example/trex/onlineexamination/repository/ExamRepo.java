package com.example.trex.onlineexamination.repository;

import com.example.trex.onlineexamination.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ExamRepo extends JpaRepository<Exam, Long> {
    List<Exam> findExamByIdAndDate(Long id, Date date);
    Exam findExamById(Long id);
    Exam findBySubjectId(Long id);
    List<Exam> findByTeacherId(Long id);


//    List<Exam> findExamByDateAndSubjectId(String date,Integer code);
}
