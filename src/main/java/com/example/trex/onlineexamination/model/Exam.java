package com.example.trex.onlineexamination.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.transform.Result;
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

    @OneToMany(mappedBy = "exam")
    private List<Question> questions;

    @JsonIgnore
    @OneToMany
    private List<Result> results;

    @Temporal(TemporalType.TIMESTAMP)
    private Date examDate;

    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;



}
