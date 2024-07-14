package com.crio.ln.Learning.Navigator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExamDetailsResponse {

    @JsonProperty("exam_id")
    private Long examId;

    @JsonProperty("student_id")
    private Long studentId;

    @JsonProperty("subject_name")
    private String subjectName;

}
