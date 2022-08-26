package com.example.trex.onlineexamination.repository;

import com.example.trex.onlineexamination.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepo extends JpaRepository<Answer, Long> {
    @Override
    List<Answer> findAll();

    List<Answer> findByQuestionId(Long questionId);
}
