package lk.sliit.lms.api.services;

import lk.sliit.lms.api.dto.CourseDTO;
import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.models.Quiz;
import lk.sliit.lms.api.repositories.CourseRepository;
import lk.sliit.lms.api.repositories.QuizRepository;
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

    @Autowired
    QuizRepository quizRepository;

    private List<Course> courses = new ArrayList<>();
    private List<CourseDTO> coursesDTO = new ArrayList<>();

    public List<Course> getAllCourses(){
        courses.clear();
        courseRepo.findAll().forEach(course->{
            courses.add(course);
        });
        System.out.print(courses);
        return  courses;
    }



    public List<CourseDTO> getAllCoursesDTO(){
        coursesDTO.clear();
        courseRepo.findAll().forEach(course->{
            CourseDTO c = new CourseDTO();
            c.setcId(course.getcId());
            c.setTitle(course.getTitle());
            c.setDescription(course.getDescription());
            c.setName(course.getName());
            coursesDTO.add(c);
        });
        System.out.print(courses);
        return  coursesDTO;
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

    public List<Quiz> getQuizForCourse(Long courseId) {
        Course course = courseRepo.findOne(courseId);

        return quizRepository.findByCourse(course);
    }
}
