package com.example.trex.onlineexamination.controller;

import com.example.trex.onlineexamination.model.RefAnswer;
import com.example.trex.onlineexamination.service.RefAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RefAnswerController {

    @Autowired
    RefAnswerService answerService;

    @PostMapping("/refAnswer")
    RefAnswer saveTest(@RequestBody RefAnswer answer) {
        return answerService.saveTest(answer);
    }

}
