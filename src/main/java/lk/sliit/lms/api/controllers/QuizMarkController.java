package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.dto.QuizMarkDTO;
import lk.sliit.lms.api.models.QuizMark;
import lk.sliit.lms.api.services.QuizMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by kashifroshen on 10/21/17.
 */
@RestController
@RequestMapping(path = "/quizzes")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizMarkController {
    @Autowired
    private QuizMarkService quizMarksService;

    @GetMapping("/{quizId}/students/{studentId}/quizmarks")
    @ResponseBody()
    public QuizMark getAllQuizzes(@PathVariable("quizId") Long quizId,@PathVariable("studentId") Long studentId){
        return quizMarksService.getMark(quizId, studentId);

    }

    @PostMapping("/{quizId}/students/{studentId}/quizmarks")
    @ResponseBody
    public QuizMark createQuizMark(@RequestBody QuizMarkDTO quizMarkDTO){
       return quizMarksService.addMarks(quizMarkDTO);
    }

    @GetMapping("/marks/{quizId}")
    public List<QuizMark> getMarks(@PathVariable("quizId") Long quizId){
        return quizMarksService.getMarks(quizId);
    }
}
