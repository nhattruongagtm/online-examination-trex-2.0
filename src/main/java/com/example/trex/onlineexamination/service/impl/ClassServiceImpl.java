package com.example.trex.onlineexamination.service.impl;

import com.example.trex.onlineexamination.model.Classes;
import com.example.trex.onlineexamination.repository.ClassRepo;
import com.example.trex.onlineexamination.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassRepo classRepo;

    @Override
    public Classes createClass(Classes classes) {
        return null;
    }

    @Override
    public Classes modifyClass(Classes classes) {
        return null;
    }

    @Override
    public void deleteClass(Classes classes) {

    }

    @Override
    public int addStudent(Long[] students, Long classID) {
        return 0;
    }

    @Override
    public boolean deleteStudent(Long studentID, Long classID) {
        return false;
    }

    @Override
    public boolean blockStudent(Long studentID, Long classID) {
        return false;
    }
}
