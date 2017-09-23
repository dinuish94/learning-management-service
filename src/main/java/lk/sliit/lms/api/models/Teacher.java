package lk.sliit.lms.api.models;

import javax.persistence.*;

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

    private String name;

    public Long getId() {
        return tId;
    }

    public void setId(Long id) {
        this.tId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
