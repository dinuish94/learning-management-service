package lk.sliit.lms.api.dto;


import java.util.Date;

/**
 * Created by dinukshakandasamanage on 9/24/17.
 */
public class QuizDTO {

    private Long course;
    private String name;
    private Date date;
    private int duration;
    private boolean isActive;

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "QuizDTO{" +
                "course=" + course +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", duration=" + duration +
                ", isActive=" + isActive +
                '}';
    }
}
