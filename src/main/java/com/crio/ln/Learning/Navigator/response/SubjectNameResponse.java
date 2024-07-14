package com.crio.ln.Learning.Navigator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SubjectNameResponse {

    @JsonProperty("subject_id")
    private Long subjectId;

    @JsonProperty("subject_name")
    private String subjectName;

    @JsonProperty("student_register_for_subject")
    private List<CreateStudentResponse> createStudentResponseList;

}
