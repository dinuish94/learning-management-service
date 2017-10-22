package lk.sliit.lms.api.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by dinukshakandasamanage on 10/22/17.
 */
@Embeddable
public class StudentAssignmentPK implements Serializable{

    @Column(name = "student_id")
    private Long student_id;

    @Column(name = "assignment_id")
    private Long assignment_id;

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(Long assignment_id) {
        this.assignment_id = assignment_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentAssignmentPK that = (StudentAssignmentPK) o;

        if (student_id != null ? !student_id.equals(that.student_id) : that.student_id != null) return false;
        return assignment_id != null ? assignment_id.equals(that.assignment_id) : that.assignment_id == null;
    }

    @Override
    public int hashCode() {
        int result = student_id != null ? student_id.hashCode() : 0;
        result = 31 * result + (assignment_id != null ? assignment_id.hashCode() : 0);
        return result;
    }
}
