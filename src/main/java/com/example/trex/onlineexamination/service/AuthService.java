package com.example.trex.onlineexamination.service;

import com.example.trex.onlineexamination.model.User;

import java.util.List;

public interface AuthService {
    User login(String username, String password);
    User signUp(User user);
    List<User> getAll();

}
