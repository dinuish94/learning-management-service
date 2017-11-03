package lk.sliit.lms.api.dto;

/**
 * Created by Jonathan on 10/30/2017.
 */
public class StudentAssignmentDTO {
    private long assignId;
    private String name;
    private String description;
    private long marks;
    private String feedback;
    private long cId;
    private long studentId;

    public long getCourseId() {
        return cId;
    }

    public void setCourseId(long courseId) {
        this.cId = courseId;
    }

    public long getAssignId() {
        return assignId;
    }

    public void setAssignId(long assignId) {
        this.assignId = assignId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getMarks() {
        return marks;
    }

    public void setMarks(long marks) {
        this.marks = marks;
    }

    public long getcId() {
        return cId;
    }

    public void setcId(long cId) {
        this.cId = cId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
