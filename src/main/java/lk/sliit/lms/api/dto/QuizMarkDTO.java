package lk.sliit.lms.api.dto;

import lk.sliit.lms.api.models.AnsweredQuestion;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kashifroshen on 10/21/17.
 */
public class QuizMarkDTO {

    long marks;
    long quiz;
    long student;
    List<AnsweredQuestionDTO> answeredQuestions;

    public long getMarks() {
        return marks;
    }

    public void setMarks(long marks) {
        this.marks = marks;
    }

    public long getQuiz() {
        return quiz;
    }

    public void setQuiz(long quiz) {
        this.quiz = quiz;
    }

    public long getStudent() {
        return student;
    }

    public void setStudent(long student) {
        this.student = student;
    }

    public List<AnsweredQuestionDTO> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(List<AnsweredQuestionDTO> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }

    @Override
    public String toString() {
        return "QuizMarkDTO{" +
                "marks=" + marks +
                ", quiz=" + quiz +
                ", student=" + student +
                ", correctQuestions=" + answeredQuestions +
                '}';
    }
}
