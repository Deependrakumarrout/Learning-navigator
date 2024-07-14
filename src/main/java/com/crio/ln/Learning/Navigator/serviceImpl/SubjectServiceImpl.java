package com.crio.ln.Learning.Navigator.serviceImpl;

import com.crio.ln.Learning.Navigator.model.Student;
import com.crio.ln.Learning.Navigator.model.Subject;
import com.crio.ln.Learning.Navigator.repository.StudentRepository;
import com.crio.ln.Learning.Navigator.repository.SubjectRepository;
import com.crio.ln.Learning.Navigator.request.EnrollSubjectRequest;
import com.crio.ln.Learning.Navigator.request.SubjectRegisterRequest;
import com.crio.ln.Learning.Navigator.response.CreateStudentResponse;
import com.crio.ln.Learning.Navigator.response.SubjectNameResponse;
import com.crio.ln.Learning.Navigator.service.SubjectService;
import com.crio.ln.Learning.Navigator.utility.FinalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public FinalResponse createSubject(EnrollSubjectRequest enrollSubjectRequest) {
        Subject subject = new Subject();
        subject.setSubjectName(enrollSubjectRequest.getSubjectName());
        List<SubjectRegisterRequest> enrollSubjectRequest1 = enrollSubjectRequest.getEnrollSubjectRequest();

        List<Student> registerForSubjects = new ArrayList<>();

        for(SubjectRegisterRequest subjectRegisterRequest: enrollSubjectRequest1) {
            Student registerForStudent = new Student();
           // registerForSubject.setStudentId(subjectRegisterRequest.getStudentId());

            registerForStudent.setStudentName(subjectRegisterRequest.getStudentName());
            subject.setStudent(registerForStudent);
            registerForStudent.setRegisteredStudent(subject);
            registerForSubjects.add((registerForStudent));
        }

        subject.setRegisteredStudent(registerForSubjects);
        subjectRepository.save(subject);
        studentRepository.saveAll(registerForSubjects);



        FinalResponse response = new FinalResponse();
        response.setStatus("true");
        response.setMessage("save successfully");
        response.setObject(null);

        return response;
    }

    @Override
    public FinalResponse getSubjectDetails(Long id) {
        SubjectNameResponse subjectNameResponse = new SubjectNameResponse();

        Optional<Subject> byId = subjectRepository.findById(id);
        Subject subject = byId.get();

        subjectNameResponse.setSubjectName(subject.getSubjectName());
        subjectNameResponse.setSubjectId(subject.getSubjectId());

        List<Student> bySubjectId = studentRepository.getStudentsByStudentId(subject.getStudent().getStudentId());

        List<CreateStudentResponse> registerForSubjects = new ArrayList<>();
        for(Student registerForSubject: bySubjectId) {
            CreateStudentResponse studentResponse = new CreateStudentResponse();
            studentResponse.setStudentId(registerForSubject.getStudentId());
            studentResponse.setStudentName(registerForSubject.getStudentName());
            registerForSubjects.add(studentResponse);
        }

        subjectNameResponse.setCreateStudentResponseList(registerForSubjects);

        FinalResponse response = new FinalResponse();
        response.setStatus("true");
        response.setMessage("Data Fetched subjected");
        response.setObject(subjectNameResponse);
        return response;
    }

    @Override
    public FinalResponse deleteSubjectDetails(Long id) {

       // Optional<StudentRegisterForSubject> byId = studentRegisterRepository.findById(id);
        List<Student> bySubjectId = studentRepository.getStudentsByStudentId(id);
        for(Student registerForSubject: bySubjectId) {
            studentRepository.deleteById(registerForSubject.getStudentId());
        }

        subjectRepository.deleteById(id);

        FinalResponse response = new FinalResponse();
        response.setStatus("true");
        response.setMessage("Subject Data Deleted Successfully");
        response.setObject(null);
        return response;

    }
}
