package com.example.trex.onlineexamination.controller;

import com.example.trex.onlineexamination.service.StudentService;
import com.example.trex.onlineexamination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class StudentController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

//    @PostMapping("/addStudent")
//    public ResponseEntity<?> addUser(@RequestBody User u){
//        if (u.getType() == 0){
//            User user = userService.addStudent(u);
//            return  ResponseEntity.ok("ok");
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
//    }
}
