package com.crio.ln.Learning.Navigator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateStudentResponse {


    @JsonProperty("student_id")
    private Long studentId;

    @JsonProperty("student_name")
    private String studentName;





}
