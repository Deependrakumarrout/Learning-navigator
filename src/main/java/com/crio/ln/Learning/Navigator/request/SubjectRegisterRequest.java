package com.crio.ln.Learning.Navigator.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SubjectRegisterRequest {

    @JsonProperty("student_registration_id")
    private long studentId;

    @JsonProperty("student_name")
    private String studentName;
}
