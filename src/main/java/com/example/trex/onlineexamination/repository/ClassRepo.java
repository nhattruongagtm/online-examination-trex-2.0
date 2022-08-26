package com.example.trex.onlineexamination.repository;

import com.example.trex.onlineexamination.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassRepo extends JpaRepository<Classes,Long> {
    Optional<Classes> findById(Integer id);

}
