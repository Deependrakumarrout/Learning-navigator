package com.crio.ln.Learning.Navigator.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EnrollSubjectRequest {

    @JsonProperty("subject_name")
    private String subjectName;

    @JsonProperty("enrollSubjectRequest")
    private List<SubjectRegisterRequest> enrollSubjectRequest;
}
