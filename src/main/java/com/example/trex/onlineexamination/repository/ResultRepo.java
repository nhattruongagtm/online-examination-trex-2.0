package com.example.trex.onlineexamination.repository;

import com.example.trex.onlineexamination.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepo extends JpaRepository<Result, Long> {
}
