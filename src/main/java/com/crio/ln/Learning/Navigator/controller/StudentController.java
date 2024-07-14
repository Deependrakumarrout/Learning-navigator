package com.crio.ln.Learning.Navigator.controller;

import com.crio.ln.Learning.Navigator.request.CreateStudentRequest;
import com.crio.ln.Learning.Navigator.service.StudentService;
import com.crio.ln.Learning.Navigator.utility.FinalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create-student")
    public FinalResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
       return studentService.createStudent(createStudentRequest);
    }

    // http://localhost:8080/api/v1/student/create-student


    @GetMapping("/get-student-details/{id}")
    public FinalResponse getStudentDetails(@PathVariable("id") Long id) {
        return studentService.getStudentDetails(id);
    }

    @DeleteMapping("/delete-student-details/{id}")
    public FinalResponse deleteStudentDetail(@PathVariable("id") Long id) {
        return studentService.deleteStudentDetails(id);
    }

}
