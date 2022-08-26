package com.example.trex.onlineexamination.repository;

import com.example.trex.onlineexamination.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
