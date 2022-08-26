package com.example.trex.onlineexamination.service.impl;

import com.example.trex.onlineexamination.dto.SubjectRequest;
import com.example.trex.onlineexamination.model.Classes;
import com.example.trex.onlineexamination.model.Student;
import com.example.trex.onlineexamination.model.Subject;
import com.example.trex.onlineexamination.model.User;
import com.example.trex.onlineexamination.repository.SubjectRepo;
import com.example.trex.onlineexamination.repository.UserRepo;
import com.example.trex.onlineexamination.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private UserRepo userRepo;
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

    @Override
    public List<Subject> getAllByStudentId(Long studentId) {
        List<Subject> listSubject = subjectRepo.findByStudentId(studentId);
        return listSubject;
    }

    @Override
    public Map<String, Object> insertSubject(long studentId, SubjectRequest subjectRequest) {
//        Map<String, Object> result= new HashMap<>();
//        Subject subject = new Subject(subjectRequest);
//        if (subjectRepo.findByName(
//                subject.getName()
//        ).size() > 0
//        ) {
//            result.put("msg","Tên môn đã tồn tại");
//            return result;
//        }
//        Optional<User> userOptional = userRepo.findById(935L);
//        if(!userOptional.isPresent()){
//            result.put("msg","Giáo viên không tồn tại");
//            return result;
//        }
//        User user = userOptional.get();
//        Student student = new Student(studentId, "Diem My");
//        subject.setStudent(student);
//        subject.setUser(user);
//        subject = subjectRepo.save(subject);
//        result.put("msg","Thêm môn thành công");
//        result.put("subject",subject);
//        return result;
        return null;
    }

    @Override
    public List<Subject> getListSubjectIdTeacher(Long Id) {
        return subjectRepo.findByUserId(Id);
    }
}
