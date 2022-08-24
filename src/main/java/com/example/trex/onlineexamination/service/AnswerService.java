package com.example.trex.onlineexamination.service;

import com.example.trex.onlineexamination.model.Answer;

public interface AnswerService {
    Answer createAnswer(Answer answer);

    Answer updateAnswer(Answer answer);

    void deleteAnswer(Long id);

}
