package lk.sliit.lms.api.services;

import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 9/26/2017.
 */
@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepo;


    private List<Course> courses = new ArrayList<>();

    public List<Course> getAllCourses(){
        courses.clear();
        courseRepo.findAll().forEach(course->{
            courses.add(course);
        });
        System.out.println(courses);
        return  courses;
    }

    public Course getCourse(String courseId){
        long id = Long.parseLong(courseId);
        Course course = courseRepo.findOne(id);
        return course;
    }
}
