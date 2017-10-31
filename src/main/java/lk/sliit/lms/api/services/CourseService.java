package lk.sliit.lms.api.services;

import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 9/26/2017.
 */
@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepo;

    @Autowired
    CourseService courseService;

    private List<Course> courses = new ArrayList<>();

    public List<Course> getAllCourses(){
        courses.clear();
        courseRepo.findAll().forEach(course->{
            courses.add(course);
        });
        return  courses;
    }

    public Course getCourse(Long courseId){
        return courseRepo.findOne(courseId);
    }

     /**
     * add a new course
     */

    public Course createCourse(Course course){
        return courseRepo.save(course);
    }

    /**
     * delete a course
     */
    public void deleteCourse(@Valid @RequestBody Long cId){
        courseService.deleteCourse(cId);
    }
}
