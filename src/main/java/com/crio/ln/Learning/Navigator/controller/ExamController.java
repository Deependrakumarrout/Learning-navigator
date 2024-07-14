package com.crio.ln.Learning.Navigator.controller;

import com.crio.ln.Learning.Navigator.request.CreateExamRequest;
import com.crio.ln.Learning.Navigator.service.ExamService;
import com.crio.ln.Learning.Navigator.utility.FinalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @RequestMapping("create-exam")
    public FinalResponse createExam(@RequestBody CreateExamRequest createExamRequest) {
        return examService.createExam(createExamRequest);
    }

    @RequestMapping("get-exam-details/{id}")
    public FinalResponse getExamDetails(@PathVariable("id") Long id) {
        return examService.getExamDetailsById(id);
    }

    @RequestMapping("delete-exam-details/{id}")
    public FinalResponse deleteExamDetails(@PathVariable("id") Long id) {
        return examService.deleteExamDetailsById(id);
    }



}
