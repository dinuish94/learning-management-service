package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.dto.CourseDTO;
import lk.sliit.lms.api.dto.StudentAssignmentDTO;
import lk.sliit.lms.api.models.Enrollment;
import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.models.StudentAssignment;
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

    @GetMapping("")
    @ResponseBody
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    @ResponseBody
    public Student getStudent(@PathVariable("studentId") String studentId){
        return studentService.getStudent(studentId);
    }

    @PostMapping("/courses")
    @ResponseBody
    public ResponseEntity<String> enrollStudent(@RequestBody Enrollment enrollment){
        return studentService.enroll(enrollment);
    }

    @DeleteMapping("/{sId}/courses/{cId}")
    @ResponseBody
    public ResponseEntity<String> unEnrollStudent(@PathVariable("sId") String studentId,@PathVariable("cId") String courseId ){
        return studentService.unEnroll(studentId,courseId);
    }


    @GetMapping("/{studentId}/assignments")
    @ResponseBody
    public List<StudentAssignmentDTO> getAllAssignmentsForStudent(@PathVariable("studentId") String studentId){
        return studentService.getAllAssignmentsForStudent(studentId);
    }

    @GetMapping("/{studentId}/courses")
    @ResponseBody
    public List<CourseDTO> getAllCoursesForStudent(@PathVariable("studentId") String studentId){
        return studentService.getAllCoursesForStudent(studentId);
    }
}
