package com.example.trex.onlineexamination.service.impl;

import com.example.trex.onlineexamination.model.User;
import com.example.trex.onlineexamination.repository.UserRepo;
import com.example.trex.onlineexamination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @Override
    public User changePassword(Long id, String password) {
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()){
            User u = user.get();
            u.setPassword(passwordEncoder.encode(password));
            return userRepo.save(u);
        }
        return null;
    }
}
