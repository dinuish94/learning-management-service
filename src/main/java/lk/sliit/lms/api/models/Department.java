package lk.sliit.lms.api.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dinukshakandasamanage on 9/23/17.
 */

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dId;

    private String name;

    private String description;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Course> courses;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Teacher> teachers;

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Student> students;

    public Department(String name, String description, Set<Course> courses, Set<Teacher> teachers, Set<Student> students) {
        this.name = name;
        this.description = description;
        this.courses = courses;
        this.teachers = teachers;
        this.students = students;
    }

    public Department(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
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

    @Override
    public String toString() {
        return String.format("Department[id=%d, name='%s']", dId, name);
    }

}
