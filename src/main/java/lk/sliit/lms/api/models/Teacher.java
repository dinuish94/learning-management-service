package lk.sliit.lms.api.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Represents the teacher entity
 *
 * Created by dinukshakandasamanage on 9/22/17.
 */

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tId;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(mappedBy = "teachers")
    private Set<Course> courses;

    private String name;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return tId;
    }

    public void setId(Long id) {
        this.tId = id;
    }

    public String getName() {
        return name;
    }

    public Teacher(Department department, String name) {
        this.department = department;
        this.name = name;
    }

    public Teacher() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public Long gettId() {
        return tId;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
