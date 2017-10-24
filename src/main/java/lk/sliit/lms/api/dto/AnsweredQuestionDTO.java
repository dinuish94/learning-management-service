package lk.sliit.lms.api.dto;

import java.util.List;

/**
 * Created by kashifroshen on 10/23/17.
 */
public class AnsweredQuestionDTO {
    private Long question;
    private String selectedAnswer;

    public AnsweredQuestionDTO(Long queId, String selectedAnswer) {
        this.question = queId;
        this.selectedAnswer = selectedAnswer;
    }

    public AnsweredQuestionDTO() {}

    public Long getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "AnsweredQuestionDTO{" +
                "queId=" + question +
                ", selectedAnswer='" + selectedAnswer + '\'' +
                '}';
    }

    public void setQueId(Long question) {
        this.question = question;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}
