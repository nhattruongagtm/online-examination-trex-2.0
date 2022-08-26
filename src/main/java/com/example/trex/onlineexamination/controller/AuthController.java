package com.example.trex.onlineexamination.controller;

import com.example.trex.onlineexamination.dto.AuthDTO;
import com.example.trex.onlineexamination.dto.LoginRequest;
import com.example.trex.onlineexamination.model.User;
import com.example.trex.onlineexamination.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public AuthDTO Login(@RequestBody User user){
        User u = authService.login(user.getUsername(),user.getPassword());
        if(u!=null){
            AuthDTO dto = new AuthDTO();
            dto.setId(u.getId());
            dto.setName(u.getFullName());
            dto.setPhotoUrl(u.getPhotoUrl());
            return dto;
        }
        return null;
    }
    @PostMapping("/signup")
    public User SignUp(@RequestBody User user){
        return authService.signUp(user);
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return authService.getAll();
    }

}
