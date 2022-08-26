package com.example.trex.onlineexamination.controller;

import com.example.trex.onlineexamination.model.RefAnswer;
import com.example.trex.onlineexamination.service.RefAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class RefAnswerController {
    @Autowired
    RefAnswerService answerService;

    @PostMapping("refAnswer")
    RefAnswer saveTest(@RequestBody RefAnswer answer) {
        return answerService.saveTest(answer);
    }

}
