package lk.sliit.lms.api.services;

import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;
import lk.sliit.lms.api.dto.QuizM;
import lk.sliit.lms.api.dto.StudentDTO;
import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.models.Enrollment;
import lk.sliit.lms.api.models.QuizMark;
import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.repositories.CourseRepository;
import lk.sliit.lms.api.repositories.QuizMarkRepository;
import lk.sliit.lms.api.repositories.StudentRepository;
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
        List<QuizM> quizMarkList= new ArrayList();

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
}
