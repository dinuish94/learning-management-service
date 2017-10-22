package lk.sliit.lms.api;

import lk.sliit.lms.api.dto.AssignmentDTO;
import lk.sliit.lms.api.models.*;
import lk.sliit.lms.api.repositories.*;
import lk.sliit.lms.api.services.AssignmentService;
import lk.sliit.lms.api.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

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

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    QuizMarkRepository quizMarkRepository;

    @Autowired
    AssignmentService assignmentService;

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

        Course course2 = new Course();
        course2.setName("Software Engineering I");
        courseRepository.save(course);

        Course course3 = new Course();
        course3.setName("Software Engineering II");
        courseRepository.save(course2);

        Course course4 = new Course();
        course4.setName("Case Studies in Software Engineering");
        courseRepository.save(course3);

        Course course5 = new Course();
        course5.setName("Software Project Management");
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

        Question question1 = new Question();
        question1.addQuestion("Test Answer 1");
        question1.addQuestion("Test Answer 2");
        question1.addQuestion("Test Answer 3");
        question1.addQuestion("Test Answer 4");

        question1.setQuiz(quiz);

        question1 = questionRepository.save(question1);

        quiz.addQuestion(question1);
        quizRepository.save(quiz);

        List<Question> Q1 = new ArrayList<>();

        Q1.add(question);
        Q1.add(question1);


        QuizMark quizMark1 = new QuizMark();
        quizMark1.setQuiz(quiz);
        quizMark1.setStudent(student2);
        quizMark1.setMarks(1);
        quizMark1.setCorrectQuestions(Q1);
        quizMarkRepository.save(quizMark1);

        AssignmentDTO assignment = new AssignmentDTO();
        assignment.setCourseId(1L);
        assignment.setDescription("test assignment");
        assignmentService.addAssignment(assignment);
    }
}


