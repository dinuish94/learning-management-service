package lk.sliit.lms.api.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dinukshakandasamanage on 9/23/17.
 */
@Entity
@Table(name = "student")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "sId")
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sId;

    private String name;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

    @OneToMany(mappedBy = "assignment")
    private Set<StudentAssignment> studentAssignment = new HashSet<StudentAssignment>();

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<StudentAssignment> getStudentAssignment() {
        return studentAssignment;
    }

    public void setStudentAssignment(Set<StudentAssignment> studentAssignment) {
        this.studentAssignment = studentAssignment;
    }

    public void addStudentAssignment(StudentAssignment studentAssignment){
        this.studentAssignment.add(studentAssignment);
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", name='" + name + '\'' +
                '}';
    }
}
