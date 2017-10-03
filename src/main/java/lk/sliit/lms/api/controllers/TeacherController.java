package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.models.Teacher;
import lk.sliit.lms.api.repositories.CourseRepository;
import lk.sliit.lms.api.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Controller class for teacher
 * Consists of endpoints to retrieve teacher related data
 *
 * Created by dinukshakandasamanage on 9/23/17.
 */
@RestController
@RequestMapping(path = "/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/")
    @ResponseBody()
    public Set<Teacher> getAllTeachers(){
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

}
