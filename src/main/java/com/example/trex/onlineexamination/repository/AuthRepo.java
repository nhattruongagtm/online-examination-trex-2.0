package com.example.trex.onlineexamination.repository;

import com.example.trex.onlineexamination.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepo extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);
    Optional<User> findByUsername(String username);
}
