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
    private Long id;

    private String name;

    @OneToMany(mappedBy = "subject")
    @JsonIgnore
    private List<Classes> classes;

    @OneToMany(mappedBy = "subject")
    @JsonIgnore
    private List<Exam> exams;

    @ManyToOne
    @JoinColumn(name = "semester")
    @JsonIgnore
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private User user;

    private String code;

    public Subject(String name) {
        this.name = name;
    }

    public Subject(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
