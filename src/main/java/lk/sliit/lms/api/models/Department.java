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

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Course> courses;

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
