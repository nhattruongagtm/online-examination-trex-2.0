package com.example.trex.onlineexamination.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    @Id
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "subject")
    @JsonIgnore
    private List<Classes> classes;

    @OneToMany(mappedBy = "subject")
    @JsonIgnore
    private List<Exam> exams;

    @ManyToOne
    @JoinColumn(name = "semester")
    private Semester semester;




}
