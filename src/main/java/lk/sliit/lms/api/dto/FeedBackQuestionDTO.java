package lk.sliit.lms.api.dto;

/**
 * Created by Jonathan on 11/2/2017.
 */
public class FeedBackQuestionDTO {
    private Long qId;
    private String question;

    public Long getqId() {
        return qId;
    }

    public void setqId(Long qId) {
        this.qId = qId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
