package com.example.trex.onlineexamination.controller;

import com.example.trex.onlineexamination.dto.LoginRequest;
import com.example.trex.onlineexamination.model.User;
import com.example.trex.onlineexamination.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;


}
