package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dinukshakandasamanage on 9/24/17.
 */
@RestController
@RequestMapping(path = "/courses")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/")
    @ResponseBody()
    public Iterable<Course> getAllQuizzes(){
        return courseRepository.findAll();
    }
}
