package com.example.trex.onlineexamination.service.impl;


import com.example.trex.onlineexamination.dto.ExamDTO;
import com.example.trex.onlineexamination.model.*;
import com.example.trex.onlineexamination.repository.ExamRepo;
import com.example.trex.onlineexamination.repository.RefAnswerRepo;
import com.example.trex.onlineexamination.repository.StudentRepo;
import com.example.trex.onlineexamination.repository.UserRepo;
import com.example.trex.onlineexamination.service.ExamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamRepo examRepository;

    @Autowired
    UserRepo userRepository;

    @Autowired
    RefAnswerRepo answerRepository;
    
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Exam createExam(Exam exam) {
        return null;
    }

    @Override
    public Exam updateExam(Exam exam) {
        return null;
    }

    @Override
    public void deleteExam(Long id) {

    }

    @Override
    public boolean checkTestPermission(Long id, Exam exam) {
        List<Exam> exams = examRepository.findExamByIdAndDate(exam.getId(), exam.getDate());
        Exam myExam = examRepository.getById(exam.getId());
        Optional<Student> user = studentRepo.findById(id);

        boolean isFound = false;
        if (user.isPresent()) {
            Subject subject = myExam.getSubject();
            List<Classes> classes = subject.getClasses();
            for (Classes clas : classes) {
                for (Student u : clas.getStudents()) {
                    System.out.println(u.getId() + "---" + id);
                    if (u.getId().equals(id)) {
                        isFound = true;
                        System.out.println(u.getUser().getFullName());
                    }
                }
            }
            System.out.println(exams.size() + "-----" + isFound);
            if (exams.size() > 0 && isFound) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public Exam getExam(Long id) {
        return examRepository.getById(id);

    }

    @Override
    public List<Exam> getListExam(Long id) {
        return examRepository.findByTeacherId(id);
    }

    @Override
    public Exam loadExam(String code) {
        String[] codes = code.split("/");
        Long subjectCode = Long.parseLong(codes[0]);
        Date examDate = Date.valueOf(codes[1]);
        List<Exam> e = examRepository.findExamByIdAndDate(subjectCode, examDate);
        return e.size() > 0 ? e.get(0) : null;
    }

    @Override
    public Exam loadExamBySubject(Long subjectId) {
        Exam exam = examRepository.findBySubjectId(subjectId);
        if (exam != null) {
            return exam;
        }
        return null;
    }

    @Override
    public List<ExamDTO> getExamListByStudentID(Long id) {
        List<Exam> exams = examRepository.findAll();
        List<ExamDTO> rs = new ArrayList<>();
        for (Exam exam : exams) {
            Subject subject = exam.getSubject();
            for (Classes classes : subject.getClasses()) {
                for (Student u : classes.getStudents()) {
                    if (u.getId().equals(id)) {
                        ExamDTO e = new ExamDTO();
                        e.setId(exam.getId());
                        e.setDuration(exam.getDuration());
                        e.setDate(exam.getDate());
                        e.setSubjectName(subject.getName());
                        e.setSubjectID(subject.getId());
                        e.setTime(exam.getTime());
                        e.setCode(subject.getCode());

                        rs.add(e);
                    }
                }
            }
        }
        return rs;

    }

    @Override
    public boolean isTest(Long uid, Long eid) {
        List<RefAnswer> rs = answerRepository.findAllByExamIdAndStudentId(eid, uid);
        return rs.size() > 0 ? true : false;
    }

    @Override
    public Exam editExam(Long id, Exam exam) {
        Exam ex = examRepository.findById(id).orElse(new Exam());
        ex.setDuration(exam.getDuration());
        ex.setDate(exam.getDate());
        ex.setTime(exam.getTime());
        ex.setSubject(exam.getSubject());

        return examRepository.save(ex);
    }

    private ExamDTO getExamBySubject(Long id) {
        Exam exam = examRepository.findBySubjectId(id);
        ExamDTO resp = new ExamDTO();
        if (exam != null) {
            resp.setId(exam.getId());
            resp.setDate(exam.getDate());
            resp.setSubjectID(exam.getSubject().getId());
            resp.setCode(exam.getSubject().getCode());
            resp.setSubjectName(exam.getSubject().getName());
            resp.setDuration(exam.getDuration());
            resp.setTime(exam.getTime());


            return resp;
        }

        return null;
    }
}
