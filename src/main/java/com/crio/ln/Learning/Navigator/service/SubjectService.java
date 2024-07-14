package com.crio.ln.Learning.Navigator.service;

import com.crio.ln.Learning.Navigator.request.EnrollSubjectRequest;
import com.crio.ln.Learning.Navigator.utility.FinalResponse;

public interface SubjectService {
    FinalResponse createSubject(EnrollSubjectRequest enrollSubjectRequest);
    FinalResponse getSubjectDetails(Long id);
    FinalResponse deleteSubjectDetails(Long id);
}
