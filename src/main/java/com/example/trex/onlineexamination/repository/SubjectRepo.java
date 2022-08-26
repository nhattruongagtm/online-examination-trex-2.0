package com.example.trex.onlineexamination.repository;

import com.example.trex.onlineexamination.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubjectRepo extends JpaRepository<Subject, Long> {

    List<Subject> findByUserId(Long Id);
    List<Subject> findByName(String name);
    Subject findSubjectById(Long Id);

}