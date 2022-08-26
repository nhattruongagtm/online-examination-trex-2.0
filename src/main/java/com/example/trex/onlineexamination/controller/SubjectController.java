package com.example.trex.onlineexamination.controller;

import java.util.List;
import java.util.Map;

import com.example.trex.onlineexamination.dto.SubjectRequest;
import com.example.trex.onlineexamination.model.ResponseObject;
import com.example.trex.onlineexamination.model.Subject;
import com.example.trex.onlineexamination.repository.SubjectRepo;
import com.example.trex.onlineexamination.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectRepo subjectRepository;

    /**
     * function to get get list subject by user_id
     * @param: studentId
     * @return: list of subject as json
     */
    @GetMapping("subject/{studentId}")
    public ResponseEntity<List<Subject>> getAll(@PathVariable(value = "studentId") Long studentId) {
        List<Subject> result = subjectService.getAllByStudentId(studentId);
        return ResponseEntity.ok(result);
    }
    @PostMapping("subject/add-subject/{studentId}")
    public ResponseEntity<ResponseObject> insertSubject(@RequestBody SubjectRequest subjectRequest,
                                                        @PathVariable long studentId){
        Map<String, Object> result = subjectService.insertSubject(studentId,subjectRequest);
        return
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject(
                                "ok",
                                (String) result.get("msg"),
                                result.get("subject")
                        )
                );
    }
//    @DeleteMapping("subject0/{id}")
//    public ResponseEntity<ResponseObject> deleteSubject(
//            @PathVariable Long id
//    ){
//        String message = subjectService.deleteSubject(id);
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new ResponseObject(
//                        "ok",
//                        message,
//                        ""+id
//                )
//        );
//    }

    @PostMapping("/subject/teacher")
    public List<Subject> getSubjectByIdTeacher(@RequestBody Long idTeacher){

        return subjectService.getListSubjectIdTeacher(idTeacher);
    }

    @GetMapping("/getAllSubject")
    public ResponseEntity getAllUser(){
        List<Subject> result = (List<Subject>) subjectRepository.findAll();
        return ResponseEntity.ok(result);
    }
}
