package lk.sliit.lms.api.models;

import javax.persistence.*;

/**
 * Created by Jonathan on 11/1/2017.
 */

@Entity
@Table(name = "feedbackanswer")
public class FeedBackAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long aId;

    @ManyToOne
    @JoinColumn(name = "feedback_q_id")
    private FeedBackQuestion feedBackQuestion;

    private String answer;

    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
        this.aId = aId;
    }

    public FeedBackQuestion getFeedBackQuestion() {
        return feedBackQuestion;
    }

    public void setFeedBackQuestion(FeedBackQuestion feedBackQuestion) {
        this.feedBackQuestion = feedBackQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
