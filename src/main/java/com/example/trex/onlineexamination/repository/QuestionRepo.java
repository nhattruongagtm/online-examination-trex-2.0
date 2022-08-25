package com.example.trex.onlineexamination.repository;

import com.example.trex.onlineexamination.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepo extends JpaRepository<Question,Long> {
    @Override
    Optional<Question> findById(Long id);

    List<Question> findByExamId(Long idSubject);
}
