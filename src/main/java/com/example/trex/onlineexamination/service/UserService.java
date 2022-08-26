package com.example.trex.onlineexamination.service;

import com.example.trex.onlineexamination.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User getUserByID(Long id);

    User save(User u);
    User addStudent(User u);

    String forgotPassword(String email);

    String resetPassword(String token, String password);

    List<User> getUsers();

    boolean isTokenExpired(LocalDateTime tokenCreationDate);

    User changePassword(Long id, String password);
    User getUserById(Long id);
    List<User> getUserByType();
    List<User> getAllStundentBySubjectId(Long id);
    List<User> getUserByClassID(long classID);

}
