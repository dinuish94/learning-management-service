//package lk.sliit.lms.api.services;
//
//import lk.sliit.lms.api.models.Feedback;
//import lk.sliit.lms.api.models.Teacher;
//import lk.sliit.lms.api.repositories.FeedbackRepository;
//import lk.sliit.lms.api.repositories.TeacherRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
///**
// * Created by nuwani on 10/28/2017.
// */
//@Service
//public class FeedbackService {
//
//    @Autowired
//    private FeedbackRepository feedbackRepository;
//
//    @Autowired
//    private TeacherRepository teacherRepository;
//
//    public List<Feedback> getAllFeedbacks(){
//        List<Feedback> feedbacks = new ArrayList<>();
//
//        feedbacks.clear();
//
//        feedbackRepository.findAll().forEach(feedback ->{
//            feedbacks.add(feedback);
//        });
//        return feedbacks;
//    }
//
//    public List<String> createFeedback (){
//
//        List<String> questions =  new ArrayList<String>();
//        questions.add("Your attendance the lectures(90%/75&/50%/below 50%)?");
//        questions.add("The grade you expect for this module(A/B/C/D/F)");
//        questions.add("Is the module content is acceptable or not acceptable? If NOT give reasons.");
//        questions.add("Does the lecturer comes to the lecture on time?");
//        questions.add("Does the lecturer answer students question(always/mostly/often/any other)");
//        questions.add("Does the subject materials are available whenever you need?");
//        questions.add("Does the students can meet the lecturer anytime?");
//        questions.add("How does the lecturer delivers the lectures?(fast/slow/moderate)");
//        questions.add("Does the lecturer gives an introduction of the lecturer before the lecturer begins?");
//        questions.add("Does every new lecture is a continuation of the previous lectures?");
//
//        return questions;
//    }
//
//}
