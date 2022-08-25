package com.example.trex.onlineexamination.service.impl;

import com.example.trex.onlineexamination.model.Classes;
import com.example.trex.onlineexamination.model.Student;
import com.example.trex.onlineexamination.repository.ClassRepo;
import com.example.trex.onlineexamination.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassRepo classRepo;

    @Override
    public Classes createClass(Classes classes) {
        return classRepo.save(classes);
    }

    @Override
    public Classes modifyClass(Classes classes) {
        Optional<Classes> clazz = classRepo.findById(classes.getId());
        if (clazz.isPresent()) {
            Classes cl = clazz.get();
            cl.setName(cl.getName());
            return classRepo.save(cl);
        }
        return null;
    }

    @Override
    public void deleteClass(Classes classes) {
        classRepo.delete(classes);
    }

    @Override
    public int addStudent(Long[] students, Long classID) {
        Optional<Classes> clazz = classRepo.findById(classID);
        if (clazz.isPresent()) {
            Classes cl = clazz.get();
            for (Long uid : students) {
                Student st = new Student();
                st.setId(uid);
                cl.getStudents().add(st);
                classRepo.save(cl);
                return students.length;
            }
        }
        return 0;
    }

    @Override
    public boolean deleteStudent(Long studentID, Long classID) {
        Optional<Classes> clazz = classRepo.findById(classID);
        if (clazz.isPresent()) {
            Classes cl = clazz.get();
            for (Student st : cl.getStudents()) {
                if (st.getId().equals(studentID)) {
                    cl.getStudents().remove(st);
                    classRepo.save(cl);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean blockStudent(Long studentID, Long classID) {
        Optional<Classes> clazz = classRepo.findById(classID);
        if (clazz.isPresent()) {
            Classes cl = clazz.get();
            for (Student st : cl.getStudents()) {
                if (st.getId().equals(studentID)) {
                    st.setStatus(true);
                    classRepo.save(cl);
                    return true;
                }
            }
        }
        return false;
    }
}
