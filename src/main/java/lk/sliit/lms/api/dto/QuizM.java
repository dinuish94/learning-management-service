package lk.sliit.lms.api.dto;

import lk.sliit.lms.api.models.AnsweredQuestion;
import lk.sliit.lms.api.models.Quiz;
import lk.sliit.lms.api.models.Student;

import java.util.List;

/**
 * Created by kashifroshen on 11/3/17.
 */
public class QuizM {
    private Long qmId;
    private Long marks;
    private Quiz quiz;
    private StudentDTO student;
    private List<AnsweredQuestion> answeredQuestions;

    public Long getQmId() {
        return qmId;
    }

    public void setQmId(Long qmId) {
        this.qmId = qmId;
    }

    public Long getMarks() {
        return marks;
    }

    public void setMarks(Long marks) {
        this.marks = marks;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public List<AnsweredQuestion> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }
}
