package lk.sliit.lms.api.services;

import lk.sliit.lms.api.dto.QuizDTO;
import lk.sliit.lms.api.dto.QuizQuestion;
import lk.sliit.lms.api.exceptions.ResourceNotFoundException;
import lk.sliit.lms.api.models.Question;
import lk.sliit.lms.api.models.Quiz;
import lk.sliit.lms.api.repositories.CourseRepository;
import lk.sliit.lms.api.repositories.QuestionRepository;
import lk.sliit.lms.api.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinukshakandasamanage on 9/23/17.
 */
@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    QuestionRepository questionRepository;

    public List<Quiz> getAllQuizzes() {
        List<Quiz> quizzes = new ArrayList<>();
        quizRepository.findAll().forEach(quizzes::add);
        return quizzes;
    }

    public Quiz createQuiz(QuizDTO quizDTO) {
        Quiz quiz = quizRepository.save(new Quiz(quizDTO.getName(), courseRepository.findOne(quizDTO.getCourse())));
        System.out.println(quiz.toString());

    return quiz;}

    public void addQuestions(long quizId, List<QuizQuestion> quizQuestions) throws ResourceNotFoundException {
        Quiz quiz = quizRepository.findOne(quizId);
        if (null != quiz) {
            quizQuestions.forEach(quizQuestion -> quiz.addQuestion(addQuestion(quiz, quizQuestion)));
        }
        throw new ResourceNotFoundException();

    }

    public Question addQuestion(Quiz quiz, QuizQuestion quizQuestion) {

        Question question = new Question();
        question.setQuiz(quiz);
        question.setAnswers(quizQuestion.getAnswers());
        question.setCorrectAnswer(quizQuestion.getCorrectAnswer());
        question.setQuestion(quizQuestion.getQuestion());

        return questionRepository.save(question);

    }
}
