package lk.sliit.lms.api;

import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.models.Question;
import lk.sliit.lms.api.models.Quiz;
import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.repositories.CourseRepository;
import lk.sliit.lms.api.repositories.QuestionRepository;
import lk.sliit.lms.api.repositories.QuizRepository;
import lk.sliit.lms.api.repositories.StudentRepository;
import lk.sliit.lms.api.services.QuizService;
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
    QuestionRepository questionRepository;

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuizService quizService;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void run(String... strings) throws Exception {

        Course course = new Course();
        course.setTitle("IT150");
        course.setDescription("Software arch");
        Student student = new Student();
        student.setName("Test Student");
        Student student2 = new Student();
        student2.setName("Jonathan");
        studentRepository.save(student2);
        course.getStudents().add(studentRepository.save(student));

        Course course = new Course();
        course.setName("Software Engineering I");
        courseRepository.save(course);

        Course course2 = new Course();
        course2.setName("Software Engineering II");
        courseRepository.save(course2);

        Course course3 = new Course();
        course3.setName("Case Studies in Software Engineering");
        courseRepository.save(course3);

        Course course4 = new Course();
        course4.setName("Software Project Management");
        courseRepository.save(course4);

        Quiz quiz = new Quiz();
        quiz.setCourse(courseRepository.findOne(1L));
        quiz = quizRepository.save(quiz);

        Question question = new Question();
        question.addQuestion("Test Answer 1");
        question.addQuestion("Test Answer 2");
        question.addQuestion("Test Answer 3");
        question.addQuestion("Test Answer 4");

        question.setQuiz(quiz);

        question = questionRepository.save(question);

        quiz.addQuestion(question);
        quizRepository.save(quiz);
    }
}


