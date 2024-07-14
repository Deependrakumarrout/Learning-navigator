package com.crio.ln.Learning.Navigator.repository;

import com.crio.ln.Learning.Navigator.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
//    @Query(value="select subject_name FROM `learning-navigator`.subject_details where student_id='?1';")
//    List<Subject> getByStudentId(Long id);

    @Query(value="SELECT * FROM subject_details WHERE student_id = ?1", nativeQuery = true)
    List<Subject> findSubjectsByStudentId(Long studentId);



}

