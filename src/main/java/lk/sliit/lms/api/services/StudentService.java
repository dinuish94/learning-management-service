package lk.sliit.lms.api.services;

import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.ir.Assignment;
import jdk.nashorn.internal.parser.JSONParser;
import lk.sliit.lms.api.dto.CourseDTO;
import lk.sliit.lms.api.dto.StudentAssignmentDTO;
import lk.sliit.lms.api.dto.StudentDTO;
import lk.sliit.lms.api.models.*;
import lk.sliit.lms.api.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
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
    StudentAssignmentRepository studentAssignmentRepository;

    @Autowired
    QuizMarkRepository quizMarkRepository;

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

    public Student createStudent(Student student){

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
//    public List<StudentAssignment> getAllAssignmentsForStudent(String studentId){
//        Student student = studentRepo.findOne(Long.parseLong(studentId));
//        List<StudentAssignment> studentAssignments = new ArrayList<>();
//        student.getStudentAssignment().forEach(studentAssignment -> studentAssignments.add(studentAssignment));
//        return studentAssignments;
//
//    }

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
//        Student student = studentRepo.findOne(Long.parseLong(studentId));
//        List<StudentAssignmentDTO> studentAssignmentDTO = new ArrayList<>();
//        student.getStudentAssignment().forEach(studentAssignment -> {
//            System.out.println("START");
//            System.out.println(studentAssignment);
//            System.out.println("END");
//            StudentAssignmentDTO assign = new StudentAssignmentDTO();
//            assign.setAssignId(studentAssignment.getAssignment().getAssignId());
//            assign.setMarks(studentAssignment.getMarks());
//            assign.setName(studentAssignment.getAssignment().getName());
//            assign.setDescription(studentAssignment.getAssignment().getDescription());
//            assign.setCourseId(studentAssignment.getAssignment().getCourse().getcId());
//            studentAssignmentDTO.add(assign);
//        });
        return studentAssignmentDTO;

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

    public List<QuizMark> getstudentQuizMarks(Long studentId) {
        Student student = studentRepo.findOne(studentId);

        return quizMarkRepository.findByStudent(student);
    }

    public Student updateStudent(long studentId,StudentDTO updatedStudent) {
        Student student = studentRepo.findOne(studentId);

        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());

        return studentRepo.save(student);
    }
}
