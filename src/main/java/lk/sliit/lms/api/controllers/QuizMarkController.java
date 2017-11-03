package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.dto.QuizDTO;
import lk.sliit.lms.api.dto.QuizMarkDTO;
import lk.sliit.lms.api.models.Question;
import lk.sliit.lms.api.models.Quiz;
import lk.sliit.lms.api.models.QuizMark;
import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.repositories.QuizRepository;
import lk.sliit.lms.api.services.QuizMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

/**
 * Created by kashifroshen on 10/21/17.
 */
@RestController
@RequestMapping(path = "/quizzes/{quizId}/students/{studentId}/quizmarks")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizMarkController {
    @Autowired
    private QuizMarkService quizMarksService;



    @GetMapping("")
    @ResponseBody()
    public QuizMark getAllQuizzes(@PathVariable("quizId") Long quizId,@PathVariable("studentId") Long studentId){
        return quizMarksService.getMark(quizId, studentId);

    }

    @PostMapping("")
    @ResponseBody
    public QuizMark createQuiz(@RequestBody QuizMarkDTO quizMarkDTO){
       return quizMarksService.addMarks(quizMarkDTO);
    }
}
