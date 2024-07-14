package com.crio.ln.Learning.Navigator.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;


@Data
public class CreateStudentRequest {

    @JsonProperty("student_name")
    private String studentName;

    @JsonProperty("enrolled_subjects")
    private List<EnrollSubjectRequest> enrollSubjectRequest;

    @JsonProperty("registered_exams")
    private List<RegisteredExamRequest> registeredExamRequest;

}
