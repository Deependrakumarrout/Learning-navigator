package com.crio.ln.Learning.Navigator.repository;

import com.crio.ln.Learning.Navigator.model.Student;
import com.crio.ln.Learning.Navigator.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {


    @Query(value="SELECT * FROM student_details WHERE student_id = ?1", nativeQuery = true)
    List<Student> getStudentsByStudentId(Long studentId);
}
