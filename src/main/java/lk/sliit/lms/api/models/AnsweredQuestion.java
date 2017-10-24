package lk.sliit.lms.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinukshakandasamanage on 9/23/17.
 */

@Entity
@Table(name = "aQuestions")
public class AnsweredQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aqueId;

    @ManyToOne
    @JoinColumn(name = "queid")
    private Question question;

    private String selectedAnswer;

    public AnsweredQuestion(Question question, String selectedAnswer) {
        this.question = question;
        this.selectedAnswer = selectedAnswer;
    }

    public AnsweredQuestion(){}

    public Long getAqueId() {
        return aqueId;
    }

    public void setAqueId(Long aqueId) {
        this.aqueId = aqueId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}
