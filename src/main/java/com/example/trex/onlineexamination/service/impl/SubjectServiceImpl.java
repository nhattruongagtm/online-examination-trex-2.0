package com.example.trex.onlineexamination.service.impl;

import com.example.trex.onlineexamination.model.Classes;
import com.example.trex.onlineexamination.model.Subject;
import com.example.trex.onlineexamination.repository.SubjectRepo;
import com.example.trex.onlineexamination.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;

    @Override
    public List<Classes> getClassesBySubject(Long id) {
        return null;
    }

    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepo.save(subject);
    }

    @Override
    public Subject modifySubject(Subject subject) {
        Optional<Subject> sj = subjectRepo.findById(subject.getId());
        if(sj.isPresent()){
            Subject sub = sj.get();
            sub.setName(subject.getName());
        }
        return null;
    }

    @Override
    public void deleteSubject(Subject subject) {
        subjectRepo.delete(subject);
    }
}
