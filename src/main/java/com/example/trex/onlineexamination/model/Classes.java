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
public class Classes{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "classes")
    @JsonIgnore
    private List<Student> students;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "subject_id")
    private Subject subject;

}
