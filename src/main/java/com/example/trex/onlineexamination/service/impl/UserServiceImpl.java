package com.example.trex.onlineexamination.service.impl;

import com.example.trex.onlineexamination.model.User;
import com.example.trex.onlineexamination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired

    @Override
    public User getUserByID(Long id) {
        return null;
    }

    @Override
    public User save(User u) {
        return null;
    }

    @Override
    public String forgotPassword(String email) {
        return null;
    }

    @Override
    public String resetPassword(String token, String password) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public boolean isTokenExpired(LocalDateTime tokenCreationDate) {
        return false;
    }
}
