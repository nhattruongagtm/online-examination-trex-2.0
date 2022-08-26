package com.example.trex.onlineexamination.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RefAnswer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "exam_id")
        private Exam exam;

        @ManyToOne
        @JsonIgnore
        @JoinColumn(name = "student_id")
        private Student student;

        @Temporal(TemporalType.TIMESTAMP)
        private Date createdDate;

        private String refAnswers;

        public int lastCorrect;

        @JsonProperty("correct")
        public int correct() {
            int rs = 0;

            if(refAnswers.equals("")){
                return 0;
            }
            else{
                String[] answers = refAnswers.split("x...x");

                Map<String, String> refs = new HashMap<>();
                for (Question q : exam.getListQuestions()) {
                    refs.put(q.getId().toString(), q.getCorrect());
                }

                for (String a : answers) {
                    String id = a.split("-")[0];
                    String right = a.split("-")[1];

                    if (refs.containsKey(id)) {
                        String ans = refs.get(id);
                        if (ans.equals(right)) {
                            rs++;
                        }
                    }
                }
            }
            return rs;
        }

        @JsonProperty("total")
        public int total() {
            return exam.getListQuestions().size();

        }

        @JsonProperty("mark")
        public double mark() {
            return (correct() * 10.0) / total();

        }

        public String getCreatedDateString() {
            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");

            return format.format(this.createdDate);
        }
    }

