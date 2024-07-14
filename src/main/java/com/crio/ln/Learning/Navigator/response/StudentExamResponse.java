package com.crio.ln.Learning.Navigator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StudentExamResponse {

    @JsonProperty("exam_id")
    public Long examId;

    @JsonProperty("subject")
    public String subject;

}
