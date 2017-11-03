package lk.sliit.lms.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by dinukshakandasamanage on 10/22/17.
 */
@Entity
@Table(name = "student_assignment")
public class StudentAssignment {

    @JsonIgnore
    @EmbeddedId
    private StudentAssignmentPK id = new StudentAssignmentPK();

    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id", referencedColumnName = "sId")
    private Student student;

    @ManyToOne
    @MapsId("assignment_id")
    @JoinColumn(name = "assignment_id", referencedColumnName = "assignId")
    private Assignment assignment;

    @Column(name = "grade")
    private long marks;

    @Column(name = "file")
    private String file;

    @Column(name = "feedback")
    private String feedback;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public StudentAssignmentPK getId() {
        return id;
    }

    public void setId(StudentAssignmentPK id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public long getMarks() {
        return marks;
    }

    public void setMarks(long marks) {
        this.marks = marks;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "StudentAssignment{" +
                "id=" + id +
                ", student=" + student +
                ", assignment=" + assignment +
                ", marks=" + marks +
                ", file='" + file + '\'' +
                '}';
    }
}
