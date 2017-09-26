package lk.sliit.lms.api;

import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.repositories.CourseRepository;
import lk.sliit.lms.api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Initializing a spring boot application
 * <p>
 * Created by dinukshakandasamanage on 9/21/17.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... strings) throws Exception {
        Course course = new Course();
        course.setTitle("IT150");
        course.setDescription("Software arch");
        Student student = new Student();
        student.setName("Test Student");
        course.getStudents().add(studentRepository.save(student));

        courseRepository.save(course);

    }
}


