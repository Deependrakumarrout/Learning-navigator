package com.crio.ln.Learning.Navigator.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CreateExamRequest {

    @JsonProperty("exam_id")
    private Long examId;

    @JsonProperty("subject_id")
    private Long subjectId;

    @JsonProperty("exam_name")
    private String examName;

    @JsonProperty("enrolled_students")
    private List<SubjectRegisterRequest> subjectRegisterRequestList;


}
