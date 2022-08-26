package com.example.trex.onlineexamination.controller;

import com.example.trex.onlineexamination.model.User;
import com.example.trex.onlineexamination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/change-pass/{id}")
    public User changePass(@PathVariable(value = "id") Long id, @RequestBody String pass){
        return userService.changePassword( id, pass);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable(value = "id") Long id,@RequestBody User u){
        User user = userService.getUserByID(id);

        if(user!=null){
            user.setFullName(u.getFullName());
            user.setPhotoUrl(u.getPhotoUrl());
            user.setEmail(u.getEmail());

            return userService.save(user);
        }
        return null;
    }

    @PostMapping("/addStudent")
    public ResponseEntity<?> addUser(@RequestBody User u){
        if (u.getType() == 0){
            User user = userService.addStudent(u);
            return  ResponseEntity.ok("ok");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
    }
    @GetMapping("/getUserByID/{id}")
    public ResponseEntity getUserById(@PathVariable(name = "id") Long id){
        User result = userService.getUserById(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/getUserByClassID/{classID}")
    public ResponseEntity getClassByID(@PathVariable(value = "classID") long classID){
        List<User> result = userService.getUserByClassID(classID);
        return ResponseEntity.ok(result);

    }
    @GetMapping("/getAllStudent")
    public ResponseEntity getAllStudent(){
        List<User> result = userService.getUserByType();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/getAllStudentBySubjectID/{subjectId}")
    public ResponseEntity getAllStudentBySubjectID(@PathVariable(value = "subjectId") Long subjectId){
        List<User> result = userService.getAllStundentBySubjectId(subjectId);
        return ResponseEntity.ok(result);
    }

}
