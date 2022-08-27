package com.example.trex.onlineexamination.controller;

import com.example.trex.onlineexamination.model.RefAnswer;
import com.example.trex.onlineexamination.service.RefAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class RefAnswerController {

    @Autowired
    RefAnswerService answerService;

    @PostMapping("/refAnswer")
    RefAnswer saveTest(@RequestBody RefAnswer answer) {
        return answerService.saveTest(answer);
    }

    @GetMapping("/refAnswer/findById")
    public List<RefAnswer> findByStudentid(@RequestParam Long id){
        return answerService.findByStudentId(id);
    }

}
