package com.example.trex.onlineexamination.controller;

import com.example.trex.onlineexamination.model.User;
import com.example.trex.onlineexamination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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



}
