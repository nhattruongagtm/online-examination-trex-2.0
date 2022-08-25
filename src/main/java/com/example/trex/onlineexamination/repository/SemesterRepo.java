package com.example.trex.onlineexamination.repository;

import com.example.trex.onlineexamination.dto.SemesterDTO;
import com.example.trex.onlineexamination.model.Semester;
import com.example.trex.onlineexamination.model.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SemesterRepo extends JpaRepository<Semester,Integer> {
    Page<Semester> findBySemesterAndYear(int semester, int year, Pageable pageable);
}
