package lk.sliit.lms.api.services;

import lk.sliit.lms.api.models.Question;
import lk.sliit.lms.api.models.Quiz;
import lk.sliit.lms.api.repositories.CourseRepository;
import lk.sliit.lms.api.repositories.QuestionRepository;
import lk.sliit.lms.api.repositories.QuizRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinukshakandasamanage on 11/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class QuizServiceTest {

    @Configuration
    static class QuizServiceTestContextConfiguration {
        @Bean
        public QuestionRepository questionRepository() {
            return Mockito.mock(QuestionRepository.class);
        }

        @Bean
        public CourseRepository courseRepository() {
            return Mockito.mock(CourseRepository.class);
        }

        @Bean
        public QuizRepository quizRepository() {
            return Mockito.mock(QuizRepository.class);
        }

        @Bean
        public QuizService quizService() {
            return Mockito.mock(QuizService.class);
        }

    }

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuizService quizService;

    @Before
    public void setUp() throws Exception {
        List<Quiz> quizzes = new ArrayList<>();

        Quiz quiz1 = new Quiz();
        quiz1.setName("quiz 1");
        quiz1.setDuration(2);
        Quiz quiz2 = new Quiz();
        quiz2.setName("quiz 2");
        quiz2.setDuration(3);

        Question q = new Question();
        q.setQuiz(quiz1);
        List<String> answers = new ArrayList<>();
        q.setAnswers(answers);
        q.setQuestion("This is the question");
        q.setCorrectAnswer("correct answer");

        quizzes.add(quiz1);
        quizzes.add(quiz2);

        Mockito.when(quizRepository.findAll()).thenReturn(quizzes);
        Mockito.when(quizRepository.findOne(Mockito.anyLong())).thenReturn(quiz1);
        Mockito.when(questionRepository.save(Mockito.any(Question.class))).thenReturn(q);

    }

    @After
    public void verify() {
//        Mockito.verify(quizRepository, VerificationModeFactory.times(1)).findAll();
        Mockito.reset(quizRepository);
        Mockito.reset(questionRepository);
    }

//    @Test
//    public void getAllQuizzes() throws Exception {
//        List<Quiz> quizzes = quizService.getAllQuizzes();
//        assertEquals("quiz 1", quizzes.get(0).getName());
//        assertEquals(2, quizzes.get(0).getDuration());
//        assertEquals("quiz 2", quizzes.get(1).getName());
//        assertEquals(3, quizzes.get(1).getDuration());
//    }
//
//    @Test
//    public void addQuestion() throws Exception{
//        QuizQuestion quizQuestion = new QuizQuestion();
//        quizQuestion.setQuestion("This is the question");
//        quizQuestion.setCorrectAnswer("Correct");
//        List<String> answers = new ArrayList<>();
//        quizQuestion.setAnswers(answers);
//        Question q = quizService.addQuestion(1, quizQuestion);
//        assertEquals("quiz 1",q.getQuiz().getName());
//
//    }


}