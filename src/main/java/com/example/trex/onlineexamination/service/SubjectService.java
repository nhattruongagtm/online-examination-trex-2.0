package com.example.trex.onlineexamination.service;

import com.example.trex.onlineexamination.model.Classes;
import com.example.trex.onlineexamination.model.Subject;

import java.util.List;

public interface SubjectService {
    List<Classes> getClassesBySubject(Long id);

    Subject createSubject(Subject subject);

    Subject modifySubject(Subject subject);

    void deleteSubject(Subject subject);
}
