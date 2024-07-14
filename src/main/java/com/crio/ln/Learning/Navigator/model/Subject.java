package com.crio.ln.Learning.Navigator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="subject_details")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="subject_id")
    private long subjectId;

    @Column(name="subject_name")
    private String subjectName;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @OneToMany(mappedBy = "subjectL", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exam> subjectL;

    @OneToMany(mappedBy = "registeredStudent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> registeredStudent;

}