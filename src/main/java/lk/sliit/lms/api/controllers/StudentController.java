package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.dto.QuizM;
import lk.sliit.lms.api.dto.StudentDTO;
import lk.sliit.lms.api.dto.DepartmentStudentDTO;
import lk.sliit.lms.api.models.Enrollment;
import lk.sliit.lms.api.models.QuizMark;
import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.services.QuizMarkService;
import lk.sliit.lms.api.services.DepartmentStudentService;
import lk.sliit.lms.api.dto.CourseDTO;
import lk.sliit.lms.api.dto.StudentAssignmentDTO;
import lk.sliit.lms.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by Jonathan on 9/26/2017.
 */
@RestController
@RequestMapping(value = "/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    private StudentService studentService;

//	 @Autowired
//    private DepartmentStudentDTO departmentStudentDTO;

    @Autowired
    private QuizMarkService quizMarkService;

    @Autowired
    private DepartmentStudentService departmentStudentService;


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
	
	  /**
     * add a new student
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody()
    public Student createStudent(@Valid @RequestBody StudentDTO student){

         return studentService.createStudent(student);
    }

    @RequestMapping(value = "/{sId}", method = RequestMethod.PUT)
    @ResponseBody
    public Student updateStudent(@PathVariable("sId") Long studentId, @RequestBody StudentDTO student) {
        return studentService.updateStudent(studentId,student);
    }

    @RequestMapping(value="/{sID}/quizzes", method= RequestMethod.GET)
    @ResponseBody
    public List<QuizM> getQuizMarks(@PathVariable("sID") Long studentId) {
        return studentService.getStudentQuizMarks(studentId);
    }


    //delete a department
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody()
    public void deleteStudent(@Valid @RequestBody Long sId){
        studentService.deleteStudent(sId);
    }

    /**
     * map students to departments
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/map", method = RequestMethod.PUT)
    @ResponseBody()
    public Student mapStudentToDepartment(@Valid @RequestBody DepartmentStudentDTO departmentStudentDTO){
        return departmentStudentService.mapStudentToCourse(departmentStudentDTO.getdId(),departmentStudentDTO.getsId());
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

