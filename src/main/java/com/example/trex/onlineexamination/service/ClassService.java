package com.example.trex.onlineexamination.service;

import com.example.trex.onlineexamination.model.Classes;

public interface ClassService {

    Classes createClass(Classes classes);

    Classes modifyClass(Classes classes);

    void deleteClass(Classes classes);

    int addStudent(Long[] students, Long classID);

    boolean deleteStudent(Long studentID, Long classID);

    boolean blockStudent(Long studentID, Long classID);

}
