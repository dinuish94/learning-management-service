package lk.sliit.lms.api.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dinukshakandasamanage on 9/23/17.
 */
@Entity
@Table(name = "course")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "cId")
public class Course{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cId;

    private String name;

    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "course_id",referencedColumnName = "cId"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "sId"))
    private Set<Student> students;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Course() {
        this.students = new HashSet<>();
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cId=" + cId +
                ", students=" + students +
                '}';
    }
}
