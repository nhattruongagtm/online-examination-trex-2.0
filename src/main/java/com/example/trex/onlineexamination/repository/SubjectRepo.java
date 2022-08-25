package com.example.trex.onlineexamination.repository;

import com.example.trex.onlineexamination.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject,Integer> {
}
