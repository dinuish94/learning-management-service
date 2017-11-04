package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.dto.FeedBackAnswerDTO;
import lk.sliit.lms.api.dto.FeedBackDTO;
import lk.sliit.lms.api.dto.FeedBackQuestionDTO;
import lk.sliit.lms.api.models.Feedback;
import lk.sliit.lms.api.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jonathan on 11/1/2017.
 */

@RestController
@RequestMapping(path = "/feedbacks")
@CrossOrigin(origins = "http://localhost:4200")
public class FeedbackController {

    @Autowired
    FeedbackService feedBackService;

    @GetMapping("/")
    @ResponseBody()
    public Iterable<Feedback> getAllFeedbacks(){
        return feedBackService.getFeedBackSessions();
    }

    @PostMapping("/")
    @ResponseBody()
    public  ResponseEntity<String> createFeedBacks(@RequestBody FeedBackDTO feedbackDTO){
        return feedBackService.createFeedBack(feedbackDTO);
    }

    @PostMapping("/feedback-answers")
    @ResponseBody()
    public ResponseEntity<String> storeFeedBacksAnswers(@RequestBody List<FeedBackAnswerDTO> feedbackDTO){
        return feedBackService.storeFeedBack(feedbackDTO);
    }

    @GetMapping("/{fId}/questions")
    @ResponseBody()
    public Iterable<FeedBackQuestionDTO> getFeedbackQuestions(@PathVariable("fId") Long fId){
        return feedBackService.getFeedbackQuestions(fId);
    }


}
