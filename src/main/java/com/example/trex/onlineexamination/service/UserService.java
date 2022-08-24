package com.example.trex.onlineexamination.service;

import com.example.trex.onlineexamination.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {
    User getUserByID(Long id);

    User save(User u);

    String forgotPassword(String email);

    String resetPassword(String token, String password);

    List<User> getUsers();

    boolean isTokenExpired(LocalDateTime tokenCreationDate);


}
