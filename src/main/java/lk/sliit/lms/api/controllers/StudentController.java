package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.dto.QuizM;
import lk.sliit.lms.api.dto.StudentDTO;
import lk.sliit.lms.api.models.Enrollment;
import lk.sliit.lms.api.models.QuizMark;
import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.services.QuizMarkService;
import lk.sliit.lms.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jonathan on 9/26/2017.
 */
@RestController
//@RequestMapping(value = "/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private QuizMarkService quizMarkService;


    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/students/{studentId}", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudent(@PathVariable("studentId") String studentId){
        return studentService.getStudent(studentId);
    }

    @RequestMapping(value = "/students/courses", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> enrollStudent(@RequestBody Enrollment enrollment){
        return studentService.enroll(enrollment);
    }
    

    @RequestMapping(value = "/students/{sId}/courses/{cId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> unEnrollStudent(@PathVariable("sId") String studentId,@PathVariable("cId") String courseId ){
        return studentService.unEnroll(studentId,courseId);
    }

    @RequestMapping(value = "/students/{sId}", method = RequestMethod.PUT)
    @ResponseBody
    public Student updateStudent(@PathVariable("sId") Long studentId, @RequestBody StudentDTO student) {
        return studentService.updateStudent(studentId,student);
    }

    @RequestMapping(value="/students/{sID}/quizzes", method= RequestMethod.GET)
    @ResponseBody
    public List<QuizM> getQuizMarks(@PathVariable("sID") Long studentId) {
        return studentService.getStudentQuizMarks(studentId);
    }

}
