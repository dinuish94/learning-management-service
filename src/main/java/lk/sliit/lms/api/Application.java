package lk.sliit.lms.api;

import lk.sliit.lms.api.dto.AssignmentDTO;
import lk.sliit.lms.api.dto.FeedBackDTO;
import lk.sliit.lms.api.models.*;
import lk.sliit.lms.api.repositories.*;
import lk.sliit.lms.api.services.AssignmentService;
import lk.sliit.lms.api.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    AnsweredQuestionRepository answeredQuestionRepository;
    @Autowired
    AssignmentService assignmentService;

    @Autowired
    StudentAssignmentRepository studentAssignmentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    FeedBackQuestionRepository feedBackQuestionRepository;

    @Autowired
    FeedbackRepository feedBackRepository;

    @Override
    public void run(String... strings) throws Exception {

        Course course = new Course();
        course.setTitle("IT150");
        course.setName("Software Architecture");

        Student student = new Student();
        student.setName("Jonathan");
        student.setEmail("jonathan@gmail.com");
        course.getStudents().add(studentRepository.save(student));
        courseRepository.save(course);


        Student student2 = new Student();
        student2.setName("Deon");
        student2.setEmail("deon@gmail.com");
        studentRepository.save(student2);

        User users1= new User();
        users1.setEmail(student.getEmail());
        users1.setRole(3);
        users1.setPassword("123");
        userRepository.save(users1);


        User users2= new User();
        users1.setEmail(student2.getEmail());
        users1.setRole(3);
        users1.setPassword("123");
        userRepository.save(users2);



        Course course2 = new Course();
        course2.setName("Software Engineering I");
        course2.setTitle("SE101");
        course2.setDescription("This is the Software Engineering I module");


        Course course3 = new Course();
        course3.setName("Software Engineering II");
        course3.setTitle("SE123");
        course3.setDescription("This is the Software Engineering II module");
        courseRepository.save(course2);

        Course course4 = new Course();
        course4.setName("Case Studies in Software Engineering");
        course4.setDescription("This is the Case Studies in Software Engineering module");
        course4.setTitle("IT123");
        courseRepository.save(course3);

        Course course5 = new Course();
        course5.setName("Software Project Management");
        course5.setTitle("Q011");
        course5.setDescription("QWER");
        courseRepository.save(course4);

        Quiz quiz = new Quiz();
        quiz.setCourse(courseRepository.findOne(1L));
        quiz = quizRepository.save(quiz);

        Question question = new Question();
        question.addQuestion("Test Answer 1");
        question.addQuestion("Test Answer 2");
        question.addQuestion("Test Answer 3");
        question.addQuestion("Test Answer 4");

        question.setQuestion("what is the answer?");
        question.setCorrectAnswer("Test Answer 4");

        question.setQuiz(quiz);

        question = questionRepository.save(question);

        quiz.setName("Software Architecture - mid");
        quiz.setDate(new Date());
        quiz.addQuestion(question);
        quiz.setDuration(2);
        quizRepository.save(quiz);

        Question question1 = new Question();
        question1.addQuestion("Test Answer 1");
        question1.addQuestion("Test Answer 2");
        question1.addQuestion("Test Answer 3");
        question1.addQuestion("Test Answer 4");

        question1.setQuestion("what is the answer?");
        question1.setCorrectAnswer("Test Answer 1");

        Question question2 = new Question();
        question2.addQuestion("Test Answer 1");
        question2.addQuestion("Test Answer 2");
        question2.addQuestion("Test Answer 3");
        question2.addQuestion("Test Answer 4");

        question2.setQuestion("what is the answer?");
        question2.setCorrectAnswer("Test Answer 1");

        Question question3 = new Question();
        question3.addQuestion("Test Answer 1");
        question3.addQuestion("Test Answer 2");
        question3.addQuestion("Test Answer 3");
        question3.addQuestion("Test Answer 4");

        question3.setQuestion("what is the answer?");
        question3.setCorrectAnswer("Test Answer 1");

        Question question4 = new Question();
        question4.addQuestion("Test Answer 1");
        question4.addQuestion("Test Answer 2");
        question4.addQuestion("Test Answer 3");
        question4.addQuestion("Test Answer 4");

        question4.setQuestion("what is the answer?");
        question4.setCorrectAnswer("Test Answer 1");

        Question question5 = new Question();
        question5.addQuestion("Test Answer 1");
        question5.addQuestion("Test Answer 2");
        question5.addQuestion("Test Answer 3");
        question5.addQuestion("Test Answer 4");

        question5.setQuestion("what is the answer?");
        question5.setCorrectAnswer("Test Answer 1");

        Question question6 = new Question();
        question6.addQuestion("Test Answer 1");
        question6.addQuestion("Test Answer 2");
        question6.addQuestion("Test Answer 3");
        question6.addQuestion("Test Answer 4");

        question6.setQuestion("what is the answer?");
        question6.setCorrectAnswer("Test Answer 1");

        Question question7 = new Question();
        question7.addQuestion("Test Answer 1");
        question7.addQuestion("Test Answer 2");
        question7.addQuestion("Test Answer 3");
        question7.addQuestion("Test Answer 4");

        question7.setQuestion("what is the answer?");
        question7.setCorrectAnswer("Test Answer 1");

        Question question8 = new Question();
        question8.addQuestion("Test Answer 1");
        question8.addQuestion("Test Answer 2");
        question8.addQuestion("Test Answer 3");
        question8.addQuestion("Test Answer 4");

        question8.setQuestion("what is the answer?");
        question8.setCorrectAnswer("Test Answer 1");

        Question question9 = new Question();
        question9.addQuestion("Test Answer 1");
        question9.addQuestion("Test Answer 2");
        question9.addQuestion("Test Answer 3");
        question9.addQuestion("Test Answer 4");

        question9.setQuestion("what is the answer?");
        question9.setCorrectAnswer("Test Answer 1");

        question1.setQuiz(quiz);
        question1 = questionRepository.save(question1);

        question2.setQuiz(quiz);
        question2 = questionRepository.save(question2);

        question3.setQuiz(quiz);
        question3 = questionRepository.save(question3);

        question4.setQuiz(quiz);
        question4 = questionRepository.save(question4);

        question5.setQuiz(quiz);
        question5 = questionRepository.save(question5);

        question6.setQuiz(quiz);
        question6 = questionRepository.save(question6);

        question7.setQuiz(quiz);
        question7 = questionRepository.save(question7);

        question8.setQuiz(quiz);
        question8 = questionRepository.save(question8);

        question9.setQuiz(quiz);
        question9 = questionRepository.save(question9);


        quiz.addQuestion(question1);
        quizRepository.save(quiz);

        List<Question> Q1 = new ArrayList<>();

        Q1.add(question);
        Q1.add(question1);

        List<AnsweredQuestion> Q2 = new ArrayList<>();

        AnsweredQuestion aq = new AnsweredQuestion(question,"Test Answer 1");
        answeredQuestionRepository.save(aq);
        AnsweredQuestion aq1 = new AnsweredQuestion(question1,"Test Answer 2");
        answeredQuestionRepository.save(aq1);
        AnsweredQuestion aq2 = new AnsweredQuestion(question2,"Test Answer 3");
        answeredQuestionRepository.save(aq2);
        AnsweredQuestion aq3 = new AnsweredQuestion(question3,"Test Answer 1");
        answeredQuestionRepository.save(aq3);

        Q2.add(aq);
        Q2.add(aq1);
        Q2.add(aq2);
        Q2.add(aq3);

        QuizMark quizMark1 = new QuizMark();
        quizMark1.setQuiz(quiz);
        quizMark1.setStudent(student2);
        quizMark1.setMarks(1);
        quizMark1.setAnsweredQuestions(Q2);
        quizMarkRepository.save(quizMark1);


        String inputString = "11-11-2017";
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date endDate = dateFormat.parse(inputString);

        AssignmentDTO assignment = new AssignmentDTO();
        assignment.setCourseId(1L);
        assignment.setDescription("test assignment");

        assignment.setEndDate(endDate);
        assignmentService.addAssignment(assignment);

        AssignmentDTO assignment2 = new AssignmentDTO();
        assignment2.setCourseId(1L);
        assignment2.setDescription("test assignment2");
        assignment2.setEndDate(endDate);
        assignmentService.addAssignment(assignment2);

        Teacher t = new Teacher();
        t.setName("Mr. Nimal");
        t.setEmail("nimal@gmail.com");
        Set<Course> courses = new HashSet<>();
        courses.add(course);
        courses.add(course2);
        courses.add(course3);
        t.setCourses(courses);
        teacherRepository.save(t);
        course.getTeachers().add(t);
        course2.getTeachers().add(t);
        course3.getTeachers().add(t);
        courseRepository.save(course);
        courseRepository.save(course2);
        courseRepository.save(course3);

        User usert1 = new User();
        usert1.setEmail(t.getEmail());
        usert1.setRole(2);
        usert1.setPassword("123");

        userRepository.save(usert1);

        List<String> fbQuestionList = new ArrayList<>();
        fbQuestionList.add("The grade you expect for this module(A/B/C/D/F)");
        fbQuestionList.add("Is the module content acceptable or not acceptable? If NOT give reasons.");
        fbQuestionList.add("Does the lecturer come to the lecture on time?");
        fbQuestionList.add("Does the lecturer answer students question?");
        fbQuestionList.add("Are subject materials available whenever you need?");
        fbQuestionList.add("Can students meet the lecturer anytime?");

        List<FeedBackQuestion> fdqList = new ArrayList<>();
        FeedBackDTO feedBackDTO = new FeedBackDTO();
        feedBackDTO.setName("Test Assignment 1");
        feedBackDTO.setTeacherId(1L);
        feedBackDTO.setFeedBackQuestions(fbQuestionList);
        Teacher teacher = teacherRepository.findOne(feedBackDTO.getTeacherId());
        Feedback feedBack = new Feedback();
        feedBack.setName(feedBackDTO.getName());
        feedBack.setTeacher(teacher);
        feedBackDTO.getFeedBackQuestions().forEach(feedBackQuestion -> {
            FeedBackQuestion fdQ = new FeedBackQuestion();
            fdQ.setFeedBack(feedBack);
            fdQ.setQuestion(feedBackQuestion);
            fdqList.add(fdQ);
        });
        feedBackRepository.save(feedBack);
        feedBackQuestionRepository.save(fdqList);

    }
}


