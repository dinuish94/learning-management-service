package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.dto.CourseDTO;
import lk.sliit.lms.api.dto.TeacherDTO;
import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.models.Teacher;
import lk.sliit.lms.api.repositories.CourseRepository;
import lk.sliit.lms.api.services.DeparmentTeacherService;
import lk.sliit.lms.api.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Controller class for teacher
 * Consists of endpoints to retrieve teacher related data
 *
 * Created by dinukshakandasamanage on 9/23/17.
 */
@RestController
@RequestMapping(path = "/teachers")
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private DeparmentTeacherService deparmentTeacherService;


    @GetMapping("")
    @ResponseBody()
    public Iterable<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    /**
     *
     * @return
     */
    @GetMapping("/courses")
    @ResponseBody
    public List<Course> getCourse(){

        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);

        return courses;

    }

      /**
     * retrieve a single teacher
     */
    @RequestMapping(value = "/teacher/{teacherID}", method = RequestMethod.GET)
    @ResponseBody()
    public Teacher getTeacher (@PathVariable("teacherID") Long teacherID){
        return teacherService.getTeacher(teacherID);
    }

    /**
     * add a new teacher
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody()
    public Teacher createTeacher (@Valid @RequestBody TeacherDTO teacher){
        return teacherService.createTeacher(teacher);
    }

    /**
     * delete a teacher
     */
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.DELETE)
    @ResponseBody()
    public void deleteTeacher(@Valid @RequestBody Long tId){
        teacherService.deleteTeacher(tId);
    }


    @RequestMapping(value = "/{id}/courses", method = RequestMethod.GET)
    @ResponseBody
    public List<CourseDTO> getCoursesForTeacher(@PathVariable Long id){
        return teacherService.getCoursesForTeacher(id);
    }

}
