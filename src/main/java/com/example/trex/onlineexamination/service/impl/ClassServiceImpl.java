package com.example.trex.onlineexamination.service.impl;

import com.example.trex.onlineexamination.dto.StudentMarkDTO;
import com.example.trex.onlineexamination.model.*;
import com.example.trex.onlineexamination.repository.ClassRepo;
import com.example.trex.onlineexamination.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<Classes> getStudentId(Long userId) {
        return null;
    }

    @Override
    public boolean checkClassIsPresent(Classes cl) {
        return false;
    }

    @Override
    public Classes addClasses(Classes cl) {
        return null;
    }

    @Override
    public List<Classes> getAllClass() {
        return null;
    }

    @Override
    public List<Classes> getClassBySubjectID(long subjectID) {
        return null;
    }

    @Override
    public Classes addClassesBySubjectId(long subjectId, Classes cl) {
        return null;
    }

    @Override
    public List<StudentMarkDTO> getMakrs(Integer classesId) {
        List<StudentMarkDTO> result = new ArrayList<>();
        Optional<Classes> classes = classRepo.findById(classesId);
        if(classes.isPresent()){
            //List of users in class
            List<Student> stu = classes.get().getStudents();
            for(Student user: stu){
                StudentMarkDTO markDTO = new StudentMarkDTO();
                markDTO.setId(user.getId());
                markDTO.setFullname(user.getUser().getFullName());
                //list of exam histories of student
                List<RefAnswer> results = user.getResults();
                List<Classes> cls = user.getClasses();
                if(results.size()!=0){
                    for(RefAnswer re: results) {
                        for (Classes classes1 : cls) {
                            if (user.getId() == re.getStudent().getId() && re.getExam().getSubject().getId() == classes1.getSubject().getId()) {
                                markDTO.setCorrect(re.correct());
                                markDTO.setTotal(re.total());
                                markDTO.setCreatedDate(re.getCreatedDateString());
                                markDTO.setMark(re.mark());
                            }
                            result.add(markDTO);
                        }
                    }
                }
                else result.add(markDTO);
            }
        }
        return result;
    }

    @Override
    public List<StudentMarkDTO> getMakrs(long subjectId,long classesId) {
        List<StudentMarkDTO> result = new ArrayList<>();
        Optional<Classes> classes = classRepo.findById(classesId);
        if(classes.isPresent()){
            //List of users in class
            List<Student> students = classes.get().getStudents();
            for(Student student: students){
                StudentMarkDTO markDTO = new StudentMarkDTO();
                markDTO.setId(student.getId());
                markDTO.setFullname(student.getUser().getFullName());
                //list of exam histories of student
                List<RefAnswer> refAnswers = student.getResults();
                if(refAnswers.size()!=0){
                    for(RefAnswer answer: refAnswers){
                        if(answer.getExam().getSubject().getId()==subjectId){
                            markDTO.setCorrect(answer.correct());
                            markDTO.setTotal(answer.total());
                            markDTO.setCreatedDate(answer.getCreatedDateString());
                            markDTO.setMark(answer.mark());
                        }
                        result.add(markDTO);
                    }
                }
                else result.add(markDTO);
            }
        }
        return result;
    }

    @Override
    public String deleteClass(long id) {
        boolean isExist = classRepo.existsById(id);
        if(isExist){
            classRepo.deleteById(id);
            return "Xóa lớp thành công";
        }else{
            return "Lớp không tồn tại";
        }
    }
}