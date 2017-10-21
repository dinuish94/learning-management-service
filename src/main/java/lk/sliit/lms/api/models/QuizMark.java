package lk.sliit.lms.api.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kashifroshen on 10/21/17.
 */
@Entity
@Table(name = "quizmark")
public class QuizMark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qmId;

    private Long marks;

    @OneToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

//    @OneToOne
//    @JoinColumn(name = "question")
//    private Question correctQuestions;

    @OneToMany
    @JoinColumn(name = "correctQuestions")
    private List<Question> correctQuestions;

    public QuizMark() {}

    public QuizMark(long marks, Quiz quiz, Student student, List<Question> correctQuestions) {
        this.marks = marks;
        this.quiz = quiz;
        this.student = student;
        this.correctQuestions = correctQuestions;
    }

    public Long getQmId() {
        return qmId;
    }

    public void setQmId(Long qmId) {
        this.qmId = qmId;
    }

    public long getMarks() {
        return marks;
    }

    public void setMarks(long marks) {
        this.marks = marks;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Question> getCorrectQuestions() {
        return correctQuestions;
    }

    public void setCorrectQuestions(List<Question> correctQuestions) {
        this.correctQuestions = correctQuestions;
    }


}
