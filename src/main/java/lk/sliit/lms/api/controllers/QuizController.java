package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.dto.QuizDTO;
import lk.sliit.lms.api.dto.QuizQuestion;
import lk.sliit.lms.api.exceptions.ResourceNotFoundException;
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

    @PostMapping("/")
    @ResponseBody
    public Quiz createQuiz(@RequestBody QuizDTO quizDTO){
        return quizService.createQuiz(quizDTO);
    }

    @PostMapping("/{id}/questions/")
    @ResponseBody
    public void addQuestionsToQuiz(@PathVariable("id") long quizId, List<QuizQuestion> quizQuestions) throws ResourceNotFoundException {
        quizService.addQuestions(quizId, quizQuestions);
    }

}
