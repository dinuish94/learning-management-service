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
import java.util.stream.Collectors;

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

    public Quiz getAllQuestionsForQuiz(Long qId){
        return quizRepository.findOne(qId);
    }

    public Quiz createQuiz(QuizDTO quizDTO) {
        Quiz quiz = new Quiz(quizDTO.getName(), courseRepository.findOne(quizDTO.getCourse()));
        quiz.setDate(quizDTO.getDate());
        quiz.setDuration(quizDTO.getDuration());
        return quizRepository.save(quiz);
    }

    public void addQuestions(long quizId, List<QuizQuestion> quizQuestions) throws ResourceNotFoundException {
        Quiz quiz = quizRepository.findOne(quizId);
        if (null != quiz) {
            quizQuestions.forEach(quizQuestion -> quiz.addQuestion(addQuestion(quizId, quizQuestion)));
        }
        throw new ResourceNotFoundException();

    }

    public Question addQuestion(long quizId, QuizQuestion quizQuestion) {
        Quiz quiz = quizRepository.findOne(quizId);

        Question question = new Question();
        question.setQuiz(quiz);
        question.setAnswers(quizQuestion.getAnswers());
        question.setCorrectAnswer(quizQuestion.getCorrectAnswer());
        question.setQuestion(quizQuestion.getQuestion());

        return questionRepository.save(question);

    }

    public void deleteQuestion(Long quizId, Long questionId) {
        questionRepository.delete(questionId);
    }

    public Question getQuestionById(Long quizId, Long questionId) {
        return questionRepository.findOne(questionId);
    }

    public Question editQuestion(Long quizId, Long questionId, QuizQuestion quizQuestion) {
        Question question = questionRepository.findOne(questionId);
        question.setQuiz(quizRepository.findOne(quizId));
        question.setAnswers(quizQuestion.getAnswers());
        question.setCorrectAnswer(quizQuestion.getCorrectAnswer());
        question.setQuestion(quizQuestion.getQuestion());
        return questionRepository.save(question);
    }

    public List<Quiz> getAllQuizzesByCourseId(Long courseId) {
        return getAllQuizzes().stream().filter(quiz -> quiz.getCourse().getcId().equals(courseId)).collect(Collectors.toList());
    }

    public Quiz markQuizAsActive(Long quizId) {
        Quiz quiz = quizRepository.findOne(quizId);
        if(quiz.isActive())
            quiz.setActive(false);
        else
            quiz.setActive(true);
        return quizRepository.save(quiz);
    }
}
