package com.crio.ln.Learning.Navigator.serviceImpl;

import com.crio.ln.Learning.Navigator.model.Exam;
import com.crio.ln.Learning.Navigator.model.Student;
import com.crio.ln.Learning.Navigator.model.Subject;
import com.crio.ln.Learning.Navigator.repository.ExamRepository;
import com.crio.ln.Learning.Navigator.repository.StudentRepository;
import com.crio.ln.Learning.Navigator.repository.SubjectRepository;
import com.crio.ln.Learning.Navigator.request.CreateStudentRequest;
import com.crio.ln.Learning.Navigator.request.EnrollSubjectRequest;
import com.crio.ln.Learning.Navigator.request.RegisteredExamRequest;
import com.crio.ln.Learning.Navigator.response.StudentExamResponse;
import com.crio.ln.Learning.Navigator.response.StudentResponse;
import com.crio.ln.Learning.Navigator.response.SubjectNameResponse;
import com.crio.ln.Learning.Navigator.service.StudentService;
import com.crio.ln.Learning.Navigator.utility.FinalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final SubjectRepository subjectRepository;

    @Autowired
    private final ExamRepository examRepository;

    public StudentServiceImpl(StudentRepository studentRepository, SubjectRepository subjectRepository, ExamRepository examRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.examRepository = examRepository;
    }

    @Override
    public FinalResponse createStudent(CreateStudentRequest createStudentRequest) {
       // System.out.println("hello");

        Student student = new Student();
        StudentResponse studentResponse = new StudentResponse();

        student.setStudentName(createStudentRequest.getStudentName());
        List<Subject> subjects = new ArrayList<>();

        Student student1 = studentRepository.save(student);
        // subjects save
        List<EnrollSubjectRequest> subjectList = createStudentRequest.getEnrollSubjectRequest();
        for(EnrollSubjectRequest subject: subjectList) {
            Subject subject1 = new Subject();
            subject1.setSubjectName(subject.getSubjectName());
            subject1.setStudent(student1);
            subjects.add(subject1);
        }

        student.setSubjectList(subjects);

        List<Subject> subjects1 = subjectRepository.saveAll(subjects);

        // exam save
        List<RegisteredExamRequest> registerExamList = createStudentRequest.getRegisteredExamRequest();
        List<Exam> examList = new ArrayList<>();
        int count = 0;
        for(RegisteredExamRequest exams: registerExamList) {
            Exam exam = new Exam();
            exam.setSubject(exams.getSubjectName());
            exam.setStudent(student1);
            exam.setSubjectL(subjects1.get(count));
            examList.add(exam);
            count++;
        }

        List<Exam> examList1 = examRepository.saveAll(examList);

        FinalResponse response = new FinalResponse();
        response.setMessage("All Data Save Successfully");
        response.setStatus("true");
        response.setObject(student1);

        return response;

    }

    @Override
    public FinalResponse getStudentDetails(Long id) {
        Optional<Student> byId = studentRepository.findById(id);
        StudentResponse studentResponse = new StudentResponse();

        List<Subject> byStudentId = subjectRepository.findSubjectsByStudentId(id);
        List<Exam> examList = examRepository.getByStudentId(id);

        if(byId.isPresent()) {
            Student student = byId.get();
            studentResponse.setStudentId(student.getStudentId());
            studentResponse.setStudentName(student.getStudentName());
            List<SubjectNameResponse> subjects = new ArrayList<>();

            //get subject details
            for(Subject subject: byStudentId) {
                SubjectNameResponse subjectNameResponse = new SubjectNameResponse();
                subjectNameResponse.setSubjectName(subject.getSubjectName());
                subjectNameResponse.setSubjectId(subject.getSubjectId());
                subjects.add(subjectNameResponse);
            }

            // get exam details
            List<StudentExamResponse> studentExamResponses = new ArrayList<>();
            for(Exam exam: examList) {
                StudentExamResponse studentExamResponse = new StudentExamResponse();
                studentExamResponse.setExamId(exam.getExamId());
                studentExamResponse.setSubject(exam.getSubject());
                studentExamResponses.add((studentExamResponse));
            }



            studentResponse.setEnrollSubjectRequest(subjects);
            studentResponse.setRegisteredExamRequest(studentExamResponses);

        }


        FinalResponse response = new FinalResponse();
        response.setMessage("Data fetched successfully");
        response.setStatus("true");
        response.setObject(studentResponse);

        return response;
    }

    @Override
    public FinalResponse deleteStudentDetails(Long id) {

        studentRepository.deleteById(id);
        subjectRepository.deleteById(id);

        FinalResponse response = new FinalResponse();
        response.setMessage("Data deleted successfully");
        response.setStatus("true");
        response.setObject(null);

        return response;

    }
}
