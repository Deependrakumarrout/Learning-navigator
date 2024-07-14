package com.crio.ln.Learning.Navigator.service;

import com.crio.ln.Learning.Navigator.request.CreateStudentRequest;
import com.crio.ln.Learning.Navigator.utility.FinalResponse;

public interface StudentService {

        FinalResponse createStudent(CreateStudentRequest createStudentRequest);
        FinalResponse getStudentDetails(Long id);
        FinalResponse deleteStudentDetails(Long id);

}
