package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.dto.CourseDTO;
import lk.sliit.lms.api.models.Assignment;
import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lk.sliit.lms.api.services.CourseService;

import java.util.List;

/**
 * Created by Jonathan on 9/26/2017.
 */
@RestController
@RequestMapping(path = "/courses")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/")
    @ResponseBody()
    public Iterable<Course> getAllQuizzes(){
        return courseService.getAllCourses();
    }


    @GetMapping("")
    @ResponseBody
    public List<CourseDTO> getAllCourses(){
        return courseService.getAllCoursesDTO();
    }

    @GetMapping("/{courseId}")
    @ResponseBody
    public Course getCourse(@PathVariable("courseId") Long courseId){
        return courseService.getCourse(courseId);
    }

    @GetMapping("/{courseId}/assignments")
    @ResponseBody
    public List<Assignment> getCourseAssignments(@PathVariable("courseId") Long courseId){
        return assignmentService.getAllAssignmentsForCourse(courseId);
    }

}
