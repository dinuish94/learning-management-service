package lk.sliit.lms.api.models;

import javax.persistence.*;

/**
 * Created by dinukshakandasamanage on 10/22/17.
 */
@Entity
@Table(name = "student_assignment")
public class StudentAssignment {

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
    private double marks;

    @Column(name = "file")
    private String file;

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

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
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
