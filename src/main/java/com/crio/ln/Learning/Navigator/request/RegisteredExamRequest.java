package com.crio.ln.Learning.Navigator.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RegisteredExamRequest {
    @JsonProperty("exam_name")
    private String subjectName;

}
