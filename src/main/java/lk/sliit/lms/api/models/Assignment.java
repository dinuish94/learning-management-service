package lk.sliit.lms.api.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dinukshakandasamanage on 10/22/17.
 */

@Entity
@Table(name = "assignment")
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "assignId")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignId;

    private String name;
    private String description;
    private Date startDate;
    private Date endDate;

//    @ManyToMany
//    @JoinTable(name = "student_assignments", joinColumns = @JoinColumn(name = "assign_id",referencedColumnName = "assignId"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "sId"))
//    private Set<Student> students;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private Set<StudentAssignment> studentAssignments;

    public Long getAssignId() {
        return assignId;
    }

    public void setAssignId(Long assignId) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @JsonIgnore
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @JsonIgnore
    public Set<StudentAssignment> getStudent() {
        return studentAssignments;
    }

    public void setStudent(Set<StudentAssignment> studentAssignments) {
        this.studentAssignments = studentAssignments;
    }
}
