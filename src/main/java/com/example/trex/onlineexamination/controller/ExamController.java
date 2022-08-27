package com.example.trex.onlineexamination.controller;

import com.example.trex.onlineexamination.dto.ExamDTO;
import com.example.trex.onlineexamination.model.Exam;
import com.example.trex.onlineexamination.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ExamController {

    @Autowired
    ExamService examService;

    @PostMapping("/checkTest/{studentId}")
    public boolean checkTestPermission(@PathVariable Long studentId, @RequestBody Exam exam ){
        return examService.checkTestPermission(studentId,exam);
    }

    @PutMapping("/exam/{id}")
    public Exam getExam(@PathVariable(name = "id") Long id, @RequestBody Exam exam){
        return examService.editExam(id,exam);
    }

    @GetMapping("/exam/{id}")
    public Exam getExam(@PathVariable(name = "id") Long id){
        return examService.getExam(id);
    }
    @PostMapping("/list-exam/{id}")
    public List<Exam> getListExam(@PathVariable(name = "id") Long id){
        return examService.getListExam(id);
    }

    @GetMapping("/exam")
    public Exam loadExam(@RequestParam(name = "code") String code){
        return examService.loadExam(code);
    }
    @GetMapping("/exams/{studentID}")
    public List<ExamDTO> loadExamList(@PathVariable(value = "studentID") Long id){
        return examService.getExamListByStudentID(id);
    }

    @GetMapping("/exam/subject/{id}")
    public Exam loadExamBySubject(@PathVariable("id") Long id){
        return examService.loadExamBySubject(id);
    }
    @GetMapping("/test/user/{uid}/exam/{examId}")
    public boolean isTest(@PathVariable("uid") Long uid,@PathVariable("examId") Long eid){
        return examService.isTest(uid,eid);
    }
}
