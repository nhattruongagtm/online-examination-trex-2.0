package com.example.trex.onlineexamination.repository;

import com.example.trex.onlineexamination.model.RefAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepo extends JpaRepository<RefAnswer, Long> {
}
