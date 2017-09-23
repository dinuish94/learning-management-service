package lk.sliit.lms.api.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
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

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", name='" + name + '\'' +
                '}';
    }
}
