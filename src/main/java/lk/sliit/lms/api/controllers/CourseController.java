package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jonathan on 9/26/2017.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    @ResponseBody
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }


    @RequestMapping(value = "/courses/{courseId}", method = RequestMethod.GET)
    @ResponseBody
    public Course getCourse(@PathVariable("courseId") String courseId){
        return courseService.getCourse(courseId);
    }
}
