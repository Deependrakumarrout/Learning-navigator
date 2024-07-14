package com.crio.ln.Learning.Navigator.serviceImpl;

import com.crio.ln.Learning.Navigator.model.Exam;
import com.crio.ln.Learning.Navigator.model.Student;
import com.crio.ln.Learning.Navigator.repository.ExamRepository;
import com.crio.ln.Learning.Navigator.repository.StudentRepository;
import com.crio.ln.Learning.Navigator.request.CreateExamRequest;
import com.crio.ln.Learning.Navigator.request.SubjectRegisterRequest;
import com.crio.ln.Learning.Navigator.response.ExamDetailsResponse;
import com.crio.ln.Learning.Navigator.service.ExamService;
import com.crio.ln.Learning.Navigator.utility.FinalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public FinalResponse createExam(CreateExamRequest createExamRequest) {

        Exam exam = new Exam();
        exam.setSubject(createExamRequest.getExamName());

        List<SubjectRegisterRequest> subjectRegisterRequestList = createExamRequest.getSubjectRegisterRequestList();

        List<Student> studentList = new ArrayList<>();
        for(SubjectRegisterRequest subjectRegisterRequest: subjectRegisterRequestList) {
            Student student = new Student();
            student.setStudentName(subjectRegisterRequest.getStudentName());
            student.setExamList(null);
            student.setSubjectList(null);
            exam.setStudent(student);
            studentList.add(student);
        }

        studentRepository.saveAll(studentList);
        exam.setSubjectL(null);

        examRepository.save(exam);

       FinalResponse response = new FinalResponse();
       response.setMessage("Save Successfully");
       response.setStatus("true");
       response.setObject(null);

       return response;
    }

    @Override
    public FinalResponse getExamDetailsById(Long id) {

        ExamDetailsResponse examDetailsResponse = new ExamDetailsResponse();

        Optional<Exam> byId = examRepository.findById(id);
        Exam exam = byId.get();
        examDetailsResponse.setExamId(exam.getExamId());
        examDetailsResponse.setSubjectName(exam.getSubject());
        examDetailsResponse.setStudentId(exam.getStudent().getStudentId());

        FinalResponse response = new FinalResponse();
        response.setMessage("Save Successfully");
        response.setStatus("true");
        response.setObject(examDetailsResponse);

        return response;

    }

    @Override
    public FinalResponse deleteExamDetailsById(Long id) {

        Optional<Exam> byId = examRepository.findById(id);
        Exam exam = byId.get();

        List<Exam> byStudentId = examRepository.getByStudentId(exam.getStudent().getStudentId());

        for(Exam examDetails: byStudentId) {
            studentRepository.deleteById(examDetails.getStudent().getStudentId());
        }

        examRepository.deleteById(id);
        FinalResponse response = new FinalResponse();
        response.setMessage("deleted successfully");
        response.setStatus("true");
        response.setObject(null);
        return response;
    }


}
