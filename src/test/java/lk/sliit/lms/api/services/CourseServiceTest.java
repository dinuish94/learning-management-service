package lk.sliit.lms.api.services;

import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.repositories.CourseRepository;
import lk.sliit.lms.api.repositories.QuizRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dinukshakandasamanage on 11/4/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CourseServiceTest {

    @Configuration
    static class CourseServiceTestContextConfiguration {
        @Bean
        public CourseService courseService() {
            return new CourseService();
        }

        @Bean
        public CourseRepository courseRepository() {
            return Mockito.mock(CourseRepository.class);
        }

        @Bean
        public QuizRepository quizRepository() {
            return Mockito.mock(QuizRepository.class);
        }
    }

    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;

    @Before
    public void setUp() throws Exception {
        List<Course> courses = new ArrayList<>();
        Course course1 = new Course();
        course1.setName("Course 1");
        course1.setTitle("C001");

        Course course2 = new Course();
        course2.setName("Course 2");
        course2.setTitle("C002");
        courses.add(course1);
        courses.add(course2);

        Mockito.when(courseRepository.findAll()).thenReturn(courses);
    }

    @After
    public void verify() {
        Mockito.verify(courseRepository, VerificationModeFactory.times(1)).findAll();
        Mockito.reset(courseRepository);
    }

    @Test
    public void getAllCourses() throws Exception {
        List<Course> courses = courseService.getAllCourses();
        assertEquals("Course 1", courses.get(0).getName());
        assertEquals("C001", courses.get(0).getTitle());
        assertEquals("Course 2", courses.get(1).getName());
        assertEquals("C002", courses.get(1).getTitle());
    }

    @Test
    public void getAllCoursesDTO() throws Exception {

    }

}