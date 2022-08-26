package com.example.trex.onlineexamination.controller;

import com.example.trex.onlineexamination.model.ResponseObject;
import com.example.trex.onlineexamination.model.User;
import com.example.trex.onlineexamination.repository.UserRepo;
import com.example.trex.onlineexamination.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/user")
public class ForgotPasswordController {

    @Autowired
    UserServiceImpl service;

    @GetMapping("/forgot-password")
    ResponseEntity<ResponseObject> forgotPassword(@RequestParam String email){
        String message = service.forgotPassword(email);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(
                        "ok",
                        message,
                        ""
                )
        );
    }

    @GetMapping("/reset-password")
    ResponseEntity<ResponseObject> resetPassword(@RequestParam String token,
                                                 @RequestParam String password){
        String message = service.resetPassword(token, password);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(
                        "ok",
                        message,
                        ""
                )
        );
    }

    @Autowired
    UserRepo repository;
    @GetMapping("/save-user")
    public User saveUser(){
//        User user = new User(1,"tanhuynh","123",new Date(12,4,200),"Huynh Ngoc Tan");
//        return repository.save(user);
        return null;
    }
}
