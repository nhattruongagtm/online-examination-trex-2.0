package com.example.trex.onlineexamination.service.impl;

import com.example.trex.onlineexamination.dto.ListResp;
import com.example.trex.onlineexamination.dto.SemesterDTO;
import com.example.trex.onlineexamination.model.Semester;
import com.example.trex.onlineexamination.model.Subject;
import com.example.trex.onlineexamination.repository.SemesterRepo;
import com.example.trex.onlineexamination.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterServiceImpl implements SemesterService {

    @Autowired
    private SemesterRepo semesterRepo;

    @Override
    public ListResp<Semester> getSubjectsBySemester(int page, int limit, int semester, int year) {
        Pageable paging = PageRequest.of(page - 1, limit);
        Page<Semester> data = semesterRepo.findBySemesterAndYear(semester,year,paging);

        List<Semester> semesters = data.getContent();
        ListResp<Semester> resp = new ListResp<>();
        resp.setList(semesters);
        resp.setTotalItems(data.getTotalElements());
        resp.setTotalPages(data.getTotalPages());
        resp.setCurrentPage(data.getNumber() + 1);
        return resp;
    }
}
