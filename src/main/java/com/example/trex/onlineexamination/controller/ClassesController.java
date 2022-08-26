package com.example.trex.onlineexamination.controller;

import com.example.trex.onlineexamination.dto.StudentMarkDTO;
import com.example.trex.onlineexamination.model.Classes;
import com.example.trex.onlineexamination.model.ResponseObject;
import com.example.trex.onlineexamination.model.User;
import com.example.trex.onlineexamination.repository.ClassRepo;
import com.example.trex.onlineexamination.service.ClassService;
import com.example.trex.onlineexamination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ClassesController {
    @Autowired
    private UserService userService;
    @Autowired
    private ClassService classesService;
    @Autowired
    private ClassRepo  classRepo;
    @GetMapping("/{classesId}/getMaks")
    public ResponseEntity<?> getMarks(  @PathVariable("classesId")Integer classesId){
//        List<StudentMarkDTO> result = classesService.getMakrs(classesId);
//        return ResponseEntity.status(HttpStatus.OK).body(result);


        return ResponseEntity.status(HttpStatus.OK).body(this.classRepo.findById(classesId).get().getStudents().get(0).getClasses().get(0).getSubject().getExams().get(0).getRefExams().get(0).lastCorrect);

    }
    @GetMapping("/subjects/{subjectId}/classes/{classesId}/getMarks")
    public ResponseEntity getMarks(@PathVariable("subjectId") long subjectId,
                                   @PathVariable("classesId")long classesId){
        List<StudentMarkDTO> result = classesService.getMakrs(subjectId,classesId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @PostMapping("/addStuToClass/{id}")
    public ResponseEntity<?> addStudentToClass(@PathVariable(value = "id") Long id,@RequestBody Classes cl){
        User u = userService.getUserByID(id);
        if (cl != null){
            u.setClasses((List<Classes>) cl);
            userService.save(u);
            return ResponseEntity.ok("Add Student To Class Success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Add Student To Class Error");
    }
    @PutMapping("/removeStuToClass/{id}")
    public ResponseEntity<?> removeStudentToClass(@PathVariable(value = "id") Long id,@RequestBody Class cl){
        User u = userService.getUserByID(id);
        if (cl != null){
            u.setClasses(null);
            userService.save(u);
            return ResponseEntity.ok("Remove Student In Class Success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Remove Student In Class Error");
    }

    @PostMapping("/addClass")
    public ResponseEntity addClasses(@RequestBody Classes cl){
        if (classesService.checkClassIsPresent(cl) == true){
            Classes cls = classesService.addClasses(cl);
            return ResponseEntity.ok(cls);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Add Class Error");
    }

    @GetMapping("/getAllClass/{subjectID}")
    public ResponseEntity getAllClass(@PathVariable(value = "subjectID") long subjectID){
        List<Classes> result = classesService.getClassBySubjectID(subjectID);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("/class/{id}")
    public ResponseEntity<ResponseObject> deleteClass(
            @PathVariable long id
    ){
        String message = classesService.deleteClass(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(
                        "ok",
                        message,
                        ""+id
                )
        );
    }

    @PostMapping("/addListStuToClass/{id}")
    public ResponseEntity<?> addListStudentToClass(@PathVariable(value = "id") List<Long> listId,@RequestBody Classes cl){
        String listNull = "";
        boolean check = true;
        for (int i = 0; i < listId.size(); i++) {
            User u = userService.getUserByID(listId.get(i));
            if (cl != null){
//                u.setClasses(cl);
                u.setClasses((List<Classes>) cl);
                userService.save(u);
                listNull+= listId.get(i)+"|";
                check = false;
            }
        }
        if (check){
            ResponseEntity.ok("Add list student success");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Add "+listNull+" Error");
    }


}
