package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.dto.QuizDTO;
import lk.sliit.lms.api.dto.QuizQuestion;
import lk.sliit.lms.api.exceptions.ResourceNotFoundException;
import lk.sliit.lms.api.models.Question;
import lk.sliit.lms.api.models.Quiz;
import lk.sliit.lms.api.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Consists of the endpoints that retrieve quiz data
 *
 * Created by dinukshakandasamanage on 9/24/17.
 */

@RestController
@RequestMapping(path = "/quizzes")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/")
    @ResponseBody()
    public List<Quiz> getAllQuizzes(){
        return quizService.getAllQuizzes();
    }

    @GetMapping("/course/{id}")
    @ResponseBody()
    public List<Quiz> getAllQuizzesByCourse(@PathVariable("id") long courseId){
        return quizService.getAllQuizzesByCourseId(courseId);
    }

    @PostMapping("/")
    @ResponseBody
    public Quiz createQuiz(@RequestBody QuizDTO quizDTO){
        return quizService.createQuiz(quizDTO);
    }

    @PostMapping("/{id}/questions/")
    @ResponseBody
    public Question addQuestionsToQuiz(@PathVariable("id") long quizId, @RequestBody QuizQuestion quizQuestions) throws ResourceNotFoundException {
        return quizService.addQuestion(quizId, quizQuestions);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Quiz getAllQuestionsForQuiz(@PathVariable("id") Long quizId){
        return quizService.getAllQuestionsForQuiz(quizId);
    }

    @GetMapping("/{id}/questions/{queId}")
    @ResponseBody
    public Question getQuestionById(@PathVariable("id") Long quizId, @PathVariable("queId") Long questionId){
        return quizService.getQuestionById(quizId, questionId);
    }

    @DeleteMapping("/{id}/questions/{queId}")
    @ResponseBody
    public boolean deleteQuestion(@PathVariable("id") Long quizId, @PathVariable("queId") Long questionId){
        quizService.deleteQuestion(quizId, questionId);
        return true;
    }

    @PutMapping("/{id}/questions/{queId}")
    @ResponseBody
    public Question editQuestion(@PathVariable("id") Long quizId,@PathVariable("queId") Long questionId, @RequestBody QuizQuestion quizQuestion){
        return quizService.editQuestion(quizId,questionId,quizQuestion);
    }

    @GetMapping("/{id}/active")
    @ResponseBody
    public Quiz markQuizAsActive(@PathVariable("id") Long quizId){
        return quizService.markQuizAsActive(quizId);
    }

}
