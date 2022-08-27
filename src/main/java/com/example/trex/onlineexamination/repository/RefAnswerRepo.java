package com.example.trex.onlineexamination.repository;

import com.example.trex.onlineexamination.model.RefAnswer;
import com.example.trex.onlineexamination.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RefAnswerRepo extends JpaRepository<RefAnswer,Long> {
    List<RefAnswer> findAllByStudentId(Long studentId);
    List<RefAnswer> findAllByExamId(Long examId);
    List<RefAnswer> findAllByExamIdAndStudentId(Long examId,Long studentId);
}
