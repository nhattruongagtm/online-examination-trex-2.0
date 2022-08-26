package com.example.trex.onlineexamination.service;

import com.example.trex.onlineexamination.dto.StudentMarkDTO;
import com.example.trex.onlineexamination.model.Classes;

import java.util.List;

public interface ClassService {

    Classes createClass(Classes classes);

    Classes modifyClass(Classes classes);

    void deleteClass(Classes classes);

    int addStudent(Long[] students, Long classID);

    boolean deleteStudent(Long studentID, Long classID);

    boolean blockStudent(Long studentID, Long classID);
    List<Classes> getStudentId(Long userId);
    boolean checkClassIsPresent(Classes cl);
    Classes addClasses(Classes cl);
    List<Classes> getAllClass();
    List<Classes> getClassBySubjectID(long subjectID);
    Classes addClassesBySubjectId(long subjectId, Classes cl);
    List<StudentMarkDTO> getMakrs(Integer classesId);
    List<StudentMarkDTO> getMakrs(long subjectId,long classesId);

    String deleteClass(long id);

}
