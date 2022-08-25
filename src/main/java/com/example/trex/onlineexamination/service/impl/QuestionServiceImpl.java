package com.example.trex.onlineexamination.service.impl;

import com.example.trex.onlineexamination.dto.CreateQuestionRequest;
import com.example.trex.onlineexamination.dto.QuestionRequest;
import com.example.trex.onlineexamination.model.Answer;
import com.example.trex.onlineexamination.model.Question;
import com.example.trex.onlineexamination.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Override
    public Question createQuestion(Question question) {
        return null;
    }

    @Override
    public Question updateQuestion(Question question) {
        return null;
    }

    @Override
    public void deleteQuestion(Long id) {

    }

    @Override
    public List<Question> getByExam(Long examID) {
        return null;
    }

    @Override
    public void saveListQuestion(QuestionRequest listQuestionRequest) {

    }

    @Override
    public QuestionRequest getListQuestion(Long idExam) {
        return null;
    }

    @Override
    public Question createQuestion(CreateQuestionRequest question) {
        return null;
    }

    @Override
    public Question updateQuestion(Long questionID, Question newQuestion) {
        return null;
    }

    @Override
    public Answer createAnswer(Answer answer) {
        return null;
    }

    @Override
    public Answer updateAnswer(Long id, Answer newAnswer) {
        return null;
    }

    @Override
    public void deleteAnswer(Long id) {

    }
}
