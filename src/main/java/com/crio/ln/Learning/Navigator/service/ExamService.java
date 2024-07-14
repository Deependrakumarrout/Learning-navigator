package com.crio.ln.Learning.Navigator.service;

import com.crio.ln.Learning.Navigator.request.CreateExamRequest;
import com.crio.ln.Learning.Navigator.utility.FinalResponse;

public interface ExamService {
    FinalResponse createExam(CreateExamRequest createExamRequest);
    FinalResponse getExamDetailsById(Long id);
    FinalResponse deleteExamDetailsById(Long id);

}
