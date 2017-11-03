package lk.sliit.lms.api.dto;

import lk.sliit.lms.api.models.FeedBackQuestion;

import java.util.List;

/**
 * Created by Jonathan on 11/1/2017.
 */
public class FeedBackDTO {
    private long teacherId;
    private String name;
    private List<String> feedBackQuestions;

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFeedBackQuestions() {
        return feedBackQuestions;
    }

    public void setFeedBackQuestions(List<String> feedBackQuestions) {
        this.feedBackQuestions = feedBackQuestions;
    }
}
