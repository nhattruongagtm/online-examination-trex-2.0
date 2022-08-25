package com.example.trex.onlineexamination.repository;

import com.example.trex.onlineexamination.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    User findByEmail(String email);
    User findByUsername(String userName);
    Optional<User> findById(Long id);
    User findByToken(String token);
//    @Query("SELECT u FROM User u WHERE u.type = 0 AND u.classes is null")
//    public List<User> findByType();
}
