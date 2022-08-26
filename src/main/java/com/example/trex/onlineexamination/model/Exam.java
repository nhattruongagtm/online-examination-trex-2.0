package com.example.trex.onlineexamination.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int duration;

    @Temporal(TemporalType.DATE)
    private Date date;

    private Date dateCreated;

    private Time time;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    @JsonIgnore
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "subject_id",referencedColumnName = "id")
    private Subject subject;

    @OneToMany(mappedBy = "exam")
    private List<Question> listQuestions;

    @JsonIgnore
    @OneToMany(mappedBy = "exam")
    private List<RefAnswer> refExams;



}
