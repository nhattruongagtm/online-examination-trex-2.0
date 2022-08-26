package com.example.trex.onlineexamination.service;

import com.example.trex.onlineexamination.dto.SubjectRequest;
import com.example.trex.onlineexamination.model.Classes;
import com.example.trex.onlineexamination.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface SubjectService{
    List<Classes> getClassesBySubject(Long id);

    Subject createSubject(Subject subject);

    Subject modifySubject(Subject subject);

    void deleteSubject(Subject subject);
    List<Subject> getAllByStudentId(Long userId);
    Map<String,Object> insertSubject(long studentId, SubjectRequest subjectRequest);
    List<Subject> getListSubjectIdTeacher(Long Id);

}
