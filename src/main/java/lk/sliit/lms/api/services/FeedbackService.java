package lk.sliit.lms.api.services;

import lk.sliit.lms.api.dto.FeedBackAnswerDTO;
import lk.sliit.lms.api.dto.FeedBackDTO;
import lk.sliit.lms.api.dto.FeedBackQuestionDTO;
import lk.sliit.lms.api.models.Feedback;
import lk.sliit.lms.api.models.FeedBackAnswer;
import lk.sliit.lms.api.models.FeedBackQuestion;
import lk.sliit.lms.api.models.Teacher;
import lk.sliit.lms.api.repositories.FeedBackAnswerRepository;
import lk.sliit.lms.api.repositories.FeedBackQuestionRepository;
import lk.sliit.lms.api.repositories.FeedbackRepository;
import lk.sliit.lms.api.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 11/1/2017.
 */
@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    FeedBackQuestionRepository feedBackQuestionRepository;

    @Autowired
    FeedBackAnswerRepository feedBackAnswerRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public List<Feedback> getFeedBackSessions(){

        List<Feedback> feedbacks = new ArrayList<>();
        feedbackRepository.findAll().forEach(feedback -> {
            feedbacks.add(feedback);
        });
        return feedbacks;
    }

    public ResponseEntity<String> createFeedBack(FeedBackDTO feedBackDTO){
        List<FeedBackQuestion> fdqList = new ArrayList<>();
        Teacher teacher = teacherRepository.findOne(feedBackDTO.getTeacherId());
        Feedback feedback = new Feedback();
        feedback.setName(feedBackDTO.getName());
        feedback.setTeacher(teacher);

        feedBackDTO.getFeedBackQuestions().forEach(feedBackQuestion -> {

            FeedBackQuestion fdQ = new FeedBackQuestion();
            fdQ.setFeedBack(feedback);
            fdQ.setQuestion(feedBackQuestion);
            fdqList.add(fdQ);
        });

        feedbackRepository.save(feedback);
        feedBackQuestionRepository.save(fdqList);
        return ResponseEntity.status(HttpStatus.CREATED).build();


    }

    public ResponseEntity<String> storeFeedBack(List<FeedBackAnswerDTO> feedBackAnswerDTO){

        List<FeedBackAnswer> feedBackAnswersList = new ArrayList<>();
        feedBackAnswerDTO.forEach(feedBackAnswerDTO1 -> {
            FeedBackAnswer fda = new FeedBackAnswer();
            fda.setFeedBackQuestion(feedBackQuestionRepository.findOne(feedBackAnswerDTO1.getqId()));
            fda.setAnswer(feedBackAnswerDTO1.getAnswer());
            feedBackAnswersList.add(fda);
        });

        feedBackAnswerRepository.save(feedBackAnswersList);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    public List<FeedBackQuestionDTO> getFeedbackQuestions(Long fId){

        List<FeedBackQuestionDTO> questionList = new ArrayList<>();
        Feedback fb= feedbackRepository.findOne(fId);
        feedBackQuestionRepository.findAll().forEach(fbqs->{
            if(fbqs.getFeedBack().getfId()==fId){
                FeedBackQuestionDTO feedBackQuestionDTO = new FeedBackQuestionDTO();
                feedBackQuestionDTO.setqId(fbqs.getqId());
                feedBackQuestionDTO.setQuestion(fbqs.getQuestion());
                questionList.add(feedBackQuestionDTO);
            }
        });


        return questionList;
    }


}
