package com.crio.ln.Learning.Navigator.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name="exam")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="exam_id")
    private long examId;

    @Column(name="subject")
    private String subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_id")
    private Subject subjectL;




}
