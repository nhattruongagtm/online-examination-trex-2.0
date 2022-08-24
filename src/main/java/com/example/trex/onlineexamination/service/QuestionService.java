package com.example.trex.onlineexamination.service;

import com.example.trex.onlineexamination.model.Question;

import java.util.List;

public interface QuestionService {
    Question createQuestion(Question question);

    Question updateQuestion(Question question);

    void deleteQuestion(Long id);

    List<Question> getByExam(Long examID);

}
