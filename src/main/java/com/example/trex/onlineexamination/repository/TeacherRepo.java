package com.example.trex.onlineexamination.repository;

import com.example.trex.onlineexamination.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    Teacher findByUserId(Long id);
}
