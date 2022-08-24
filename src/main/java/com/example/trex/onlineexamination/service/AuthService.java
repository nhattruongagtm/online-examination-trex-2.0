package com.example.trex.onlineexamination.service;

import com.example.trex.onlineexamination.model.User;

public interface AuthService {
    User login(String username, String password);

}
