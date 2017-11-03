package lk.sliit.lms.api.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * Created by Jonathan on 11/1/2017.
 */
@Entity
@Table(name = "feedbackquestion")
public class FeedBackQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qId;

    @ManyToOne
    @JoinColumn(name = "feedback_id")
    private FeedBack feedBack;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    private String question;

    public Long getqId() {
        return qId;
    }

    public void setqId(Long qId) {
        this.qId = qId;
    }

    public FeedBack getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(FeedBack feedBack) {
        this.feedBack = feedBack;
    }


}
