package com.crio.ln.Learning.Navigator.controller;


import com.crio.ln.Learning.Navigator.request.EnrollSubjectRequest;
import com.crio.ln.Learning.Navigator.service.StudentService;
import com.crio.ln.Learning.Navigator.service.SubjectService;
import com.crio.ln.Learning.Navigator.utility.FinalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/create-subject")
    public FinalResponse createSubject(@RequestBody EnrollSubjectRequest enrollSubjectRequest) {
        return subjectService.createSubject(enrollSubjectRequest);
    }

    @RequestMapping("/get-subject-details/{id}")
    public FinalResponse getSubjectDetails(@PathVariable("id") Long id) {
        return subjectService.getSubjectDetails(id);
    }


    @RequestMapping("/delete-subject-details/{id}")
    public FinalResponse deleteSubjectDetails(@PathVariable("id") Long id) {
        return subjectService.deleteSubjectDetails(id);
    }

}
