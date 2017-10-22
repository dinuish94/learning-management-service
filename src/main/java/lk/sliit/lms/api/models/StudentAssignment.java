package lk.sliit.lms.api.models;

import javax.persistence.*;

/**
 * Created by dinukshakandasamanage on 10/22/17.
 */
@Entity
@Table(name = "student_assignment")
public class StudentAssignment {

    @EmbeddedId
    private StudentAssignmentPK id;

    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id", referencedColumnName = "sId")
    private Student student;

    @ManyToOne
    @MapsId("assignment_id")
    @JoinColumn(name = "assignment_id", referencedColumnName = "assignId")
    private Assignment assignment;

    @Column(name = "grade")
    private double marks;

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

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
