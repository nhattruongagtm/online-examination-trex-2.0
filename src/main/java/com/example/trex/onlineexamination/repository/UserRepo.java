package com.example.trex.onlineexamination.repository;

import com.example.trex.onlineexamination.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

}
