package lk.sliit.lms.api.dto;

/**
 * Created by Jonathan on 11/1/2017.
 */
public class FeedBackAnswerDTO {
    private Long qId;
    private String answer;

    public Long getqId() {
        return qId;
    }

    public void setqId(Long qId) {
        this.qId = qId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
