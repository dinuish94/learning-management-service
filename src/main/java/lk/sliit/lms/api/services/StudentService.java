package lk.sliit.lms.api.services;

import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.ir.Assignment;
import jdk.nashorn.internal.parser.JSONParser;

import lk.sliit.lms.api.dto.QuizM;
import lk.sliit.lms.api.dto.StudentDTO;

import lk.sliit.lms.api.dto.CourseDTO;
import lk.sliit.lms.api.dto.StudentAssignmentDTO;
import lk.sliit.lms.api.dto.SubmissionDTO;
import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.models.Enrollment;
import lk.sliit.lms.api.models.QuizMark;
import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.models.StudentAssignment;
import lk.sliit.lms.api.models.*;
import lk.sliit.lms.api.repositories.CourseRepository;
import lk.sliit.lms.api.repositories.QuizMarkRepository;
import lk.sliit.lms.api.repositories.StudentAssignmentRepository;
import lk.sliit.lms.api.repositories.StudentRepository;
import lk.sliit.lms.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Jonathan on 9/26/2017.
 */
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepo;

    @Autowired
    CourseRepository courseRepo;

    @Autowired
    QuizMarkRepository quizMarkRepository;

    @Autowired
    StudentAssignmentRepository studentAssignmentRepository;

    @Autowired
    UserRepository userRepository;

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        students.clear();
        studentRepo.findAll().forEach(student->{
            students.add(student);
        });
        System.out.println(students);
        return students;
    }

    public Student getStudent(String studentId){
        long id = Long.parseLong(studentId);
        Student student = studentRepo.findOne(id);
        return student;
    }

    public ResponseEntity<String> enroll(Enrollment enrollment){

        Student student = studentRepo.findOne(enrollment.getsId());
        Course course = courseRepo.findOne(enrollment.getcId());
        course.getStudents().add(student);
        courseRepo.save(course);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<String> unEnroll(String studentId, String courseId){

        long sId = Long.parseLong(studentId);
        long cId = Long.parseLong(courseId);

        Student student = studentRepo.findOne(sId);
        Course course = courseRepo.findOne(cId);
        course.getStudents().remove(student);
        courseRepo.save(course);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public Student updateStudent(Long studentId, StudentDTO student) {
        Student updateStudent = studentRepo.findOne(studentId);

        if (student.getName() != null) {
            updateStudent.setName(student.getName());
        } else if (student.getEmail() != null) {
            updateStudent.setEmail(student.getEmail());
        }

        studentRepo.save(updateStudent);

        return updateStudent;
    }

    public List<QuizM> getStudentQuizMarks(Long studentId) {
//        Student student = studentRepo.findOne(studentId);
        List<QuizM> quizMarkList = new ArrayList();

        quizMarkRepository.findAll().forEach(quizMark -> {
            if (quizMark.getStudent().getsId() == studentId) {
                QuizM quizM = new QuizM();
                quizM.setQuiz(quizMark.getQuiz());
                Student student = studentRepo.findOne(quizMark.getStudent().getsId());
                StudentDTO s = new StudentDTO();
                s.setEmail(student.getEmail());
                s.setName(student.getName());
                s.setStudentId(student.getsId());
                quizM.setStudent(s);
                quizM.setAnsweredQuestions(quizMark.getAnsweredQuestions());

                quizMarkList.add(quizM);
            }

        });
        return quizMarkList;
    }

    public Student createStudent(StudentDTO newStudent){

        Student student = new Student();

        student.setName(newStudent.getName());
        student.setEmail(newStudent.getEmail());

        User s = new User();
        s.setEmail(student.getEmail());
        s.setPassword("123");
        s.setRole(3);
        userRepository.save(s);
        return studentRepo.save(student);
    }
        
    public void deleteStudent(Long sId){
        
        Student student = studentRepo.findOne(sId);
        studentRepo.delete(student);
    }

    public List<StudentAssignmentDTO> getAllAssignmentsForStudent(String studentId){
        List<StudentAssignmentDTO> studentAssignmentDTO = new ArrayList<>();
        studentAssignmentRepository.findAll().forEach(
            studentAssignment -> {
                 if(studentAssignment.getStudent().getsId()==Long.parseLong(studentId)){
                     StudentAssignmentDTO assign = new StudentAssignmentDTO();
                     assign.setAssignId(studentAssignment.getAssignment().getAssignId());
                     assign.setMarks(studentAssignment.getMarks());
                     assign.setName(studentAssignment.getAssignment().getName());
                     assign.setDescription(studentAssignment.getAssignment().getDescription());
                     assign.setCourseId(studentAssignment.getAssignment().getCourse().getcId());
                     studentAssignmentDTO.add(assign);
                 }
             }
        );
        return studentAssignmentDTO;
    }

    public List<SubmissionDTO> getAllStudentAssignments(Long assignmentId){
        List<SubmissionDTO> submissionDTOs = new ArrayList<>();
        studentAssignmentRepository.findAll().forEach(
                studentAssignment -> {
                    if(studentAssignment.getAssignment().getAssignId()==assignmentId) {
                        SubmissionDTO submissionDTO = new SubmissionDTO();
                        submissionDTO.setFile(studentAssignment.getFile());
                        submissionDTO.setStudentId(studentAssignment.getStudent().getsId());
                        submissionDTO.setStudentName(studentAssignment.getStudent().getName());
                        submissionDTO.setMarks(studentAssignment.getMarks());
                        submissionDTO.setFeedback(studentAssignment.getFeedback());
                        submissionDTOs.add(submissionDTO);
                    }
                }
        );
        return submissionDTOs;
    }

    public List<CourseDTO> getAllCoursesForStudent(String studentId){
        Student student = studentRepo.findOne(Long.parseLong(studentId));
        List<CourseDTO> courseDTO = new ArrayList<>();
        student.getCourses().forEach(course -> {
            CourseDTO c = new CourseDTO();
            c.setcId(course.getcId());
            c.setTitle(course.getTitle());
            c.setDescription(course.getDescription());
            c.setName(course.getName());

            courseDTO.add(c);
        });
        return courseDTO;

    }
}
