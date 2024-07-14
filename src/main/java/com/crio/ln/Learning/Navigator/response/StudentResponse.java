package com.crio.ln.Learning.Navigator.response;

import com.crio.ln.Learning.Navigator.model.Exam;
import com.crio.ln.Learning.Navigator.model.Subject;
import com.crio.ln.Learning.Navigator.request.EnrollSubjectRequest;
import com.crio.ln.Learning.Navigator.request.RegisteredExamRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class StudentResponse {

    @JsonProperty("student_id")
    private Long studentId;

    @JsonProperty("student_name")
    private String studentName;

    @JsonProperty("enrolled_subjects")
    private List<SubjectNameResponse> enrollSubjectRequest;

    @JsonProperty("registered_exams")
    private List<StudentExamResponse> registeredExamRequest;

}
