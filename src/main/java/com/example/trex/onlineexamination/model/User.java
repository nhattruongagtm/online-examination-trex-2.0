package com.example.trex.onlineexamination.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date DateOfBirth;

    private String fullName;

    private String phone;

    private String email;

    private String photoUrl;

    private String token;

    private Integer type;

    @Column(name = "tokenCreationDate", columnDefinition = "TIMESTAMP")
    private LocalDateTime tokenCreationDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "user_class", joinColumns = @JoinColumn(name = "class_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnore
    private List<Classes> classes;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Teacher teacher;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Student student;




}
