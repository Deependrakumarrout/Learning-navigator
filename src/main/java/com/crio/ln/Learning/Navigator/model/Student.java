package com.crio.ln.Learning.Navigator.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="student_details")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="student_id")
    private long studentId;

    @Column(name="student_name")
    private String studentName;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subject> subjectList;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exam> examList;

    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject registeredStudent;
}
