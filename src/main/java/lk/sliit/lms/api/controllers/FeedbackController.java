//package lk.sliit.lms.api.controllers;
//
//import lk.sliit.lms.api.models.Feedback;
//import lk.sliit.lms.api.repositories.FeedbackRepository;
//import lk.sliit.lms.api.repositories.TeacherRepository;
//import lk.sliit.lms.api.services.FeedbackService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * Created by nuwani on 10/28/2017.
// */
//@RestController
//@RequestMapping(value = "/feedbacks")
//@CrossOrigin(origins = "http://localhost:4200")
//public class FeedbackController {
//
//    @Autowired
//    FeedbackRepository feedbackRepository;
//
//    @Autowired
//    FeedbackService feedbackService;
//
//    @Autowired
//    TeacherRepository teacherRepository;
//
//    @RequestMapping(value = "/feedbacks", method = RequestMethod.GET)
//    @ResponseBody()
//    public List<Feedback> getAllFeedbacks(){
//        return feedbackService.getAllFeedbacks();
//    }
//
//    @RequestMapping(value = "/feedback/questions", method = RequestMethod.GET)
//    @ResponseBody()
//    public List<String> createFeedback(){
//    	return feedbackService.createFeedback();
//    }
//
//}
