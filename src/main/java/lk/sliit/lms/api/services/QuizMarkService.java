package lk.sliit.lms.api.services;

import lk.sliit.lms.api.dto.QuizMarkDTO;
import lk.sliit.lms.api.models.Question;
import lk.sliit.lms.api.models.Quiz;
import lk.sliit.lms.api.models.QuizMark;
import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kashifroshen on 10/21/17.
 */
@Service
public class QuizMarkService {
    @Autowired
    QuizMarkRepository quizMarkRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    public QuizMark addMarks(QuizMarkDTO quizMarkDTO){

        QuizMark quizMark = new QuizMark();

        Student student = studentRepository.findOne(quizMarkDTO.getStudent());
        Quiz quiz = quizRepository.findOne(quizMarkDTO.getQuiz());

       List<Question> questions = new ArrayList<>();

        for(int i=0;i<quizMarkDTO.getCorrectQuestions().length;i++) {
            questions.add(questionRepository.findOne(quizMarkDTO.getCorrectQuestions()[i]));
        }

        quizMark.setMarks(quizMarkDTO.getMarks());
        quizMark.setStudent(student);
        quizMark.setQuiz(quiz);
        quizMark.setCorrectQuestions(questions);

        quizMark = quizMarkRepository.save(quizMark);

        return quizMark;

//        return quizMarkRepository.save(quizMark);
    }


    public Iterable<QuizMark> getMarks(){
        return quizMarkRepository.findAll();

    }

    public Student getQuizMark(QuizMarkDTO quizMarkDTO) {
        return studentRepository.findOne(quizMarkDTO.getStudent());
    }
}
