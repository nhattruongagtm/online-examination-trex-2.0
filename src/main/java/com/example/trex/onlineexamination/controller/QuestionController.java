package com.example.trex.onlineexamination.controller;

import com.example.trex.onlineexamination.dto.CreateQuestionRequest;
import com.example.trex.onlineexamination.dto.QuestionRequest;
import com.example.trex.onlineexamination.model.Answer;
import com.example.trex.onlineexamination.model.Question;
import com.example.trex.onlineexamination.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping(value = "/exam/question")
    public ResponseEntity<String> getListQuestion(@RequestBody QuestionRequest questionRequest) {
        questionService.saveListQuestion(questionRequest);
        return ResponseEntity.ok("ok");

    }


    //load answers of question
    @GetMapping("question/{id}")
    public QuestionRequest getListAnswer(@PathVariable("id") Long id){
        return questionService.getListQuestion(id);
    }



    @PutMapping("question/{id}")
    public Question updateQuestion(@PathVariable("id") Long id, @RequestBody Question question){
        return questionService.updateQuestion(id,question);
    }

    @DeleteMapping("question/{id}")
    public void deleteQuestion(@PathVariable("id") Long id){
        questionService.deleteQuestion(id);
    }

    @PutMapping("answer/{id}")
    public Answer updateAnswer(@PathVariable("id") Long id, @RequestBody Answer answer){
        return questionService.updateAnswer(id,answer);
    }

    @DeleteMapping("answer/{id}")
    public void deleteAnswer(@PathVariable("id") Long id){
        questionService.deleteAnswer(id);
    }

    @PostMapping("/question")
    public Question createQuestion(@RequestBody CreateQuestionRequest question){
        return questionService.createQuestion(question);
    }

    @PostMapping("/answer")
    public Answer createAnswer(@RequestBody Answer answer){
        return questionService.createAnswer(answer);
    }

}
