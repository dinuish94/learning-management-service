package lk.sliit.lms.api.models;

import javax.persistence.*;

/**
 * Created by Jonathan on 11/1/2017.
 */
@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fId;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    private String name;

//    @OneToMany(mappedBy = "feedback", cascade = CascadeType.ALL)
//    private Set<FeedBackQuestion> feedBackQuestions;
//
//    public Set<FeedBackQuestion> getFeedBackQuestions() {
//        return feedBackQuestions;
//    }
//
//    public void setFeedBackQuestions(Set<FeedBackQuestion> feedBackQuestions) {
//        this.feedBackQuestions = feedBackQuestions;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
