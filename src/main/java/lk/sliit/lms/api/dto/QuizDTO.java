package lk.sliit.lms.api.dto;


/**
 * Created by dinukshakandasamanage on 9/24/17.
 */
public class QuizDTO {

    private Long course;
    private String name;

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

    @Override
    public String toString() {
        return "QuizDTO{" +
                "course=" + course +
                ", name='" + name + '\'' +
                '}';
    }
}
