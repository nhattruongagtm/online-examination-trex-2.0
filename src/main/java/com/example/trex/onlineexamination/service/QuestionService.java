package com.example.trex.onlineexamination.service;

import com.example.trex.onlineexamination.dto.CreateQuestionRequest;
import com.example.trex.onlineexamination.dto.QuestionRequest;
import com.example.trex.onlineexamination.model.Answer;
import com.example.trex.onlineexamination.model.Question;

import java.util.List;

public interface QuestionService {
    Question createQuestion(Question question);

    Question updateQuestion(Question question);

    void deleteQuestion(Long id);

    List<Question> getByExam(Long examID);

    void saveListQuestion(QuestionRequest listQuestionRequest);

    QuestionRequest getListQuestion(Long idExam);

    Question createQuestion(CreateQuestionRequest question);

    Question updateQuestion(Long questionID,Question newQuestion);

    Answer createAnswer(Answer answer);

    Answer updateAnswer(Long id,Answer newAnswer);

    void deleteAnswer(Long id);

}
