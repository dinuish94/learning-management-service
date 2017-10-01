package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.models.Course;
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

    @GetMapping("/")
    @ResponseBody()
    public Iterable<Course> getAllQuizzes(){
        return courseService.getAllCourses();
    }


    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    @ResponseBody
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }


    @RequestMapping(value = "/{courseId}", method = RequestMethod.GET)
    @ResponseBody
    public Course getCourse(@PathVariable("courseId") Long courseId){
        return courseService.getCourse(courseId);
    }
}
