package lk.sliit.lms.api.dto;

/**
 * Created by Jonathan on 10/30/2017.
 */
public class StudentAssignmentDTO {
    private long assignId;
    private String name;
    private String description;
    private double marks;
    private long cId;

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

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
