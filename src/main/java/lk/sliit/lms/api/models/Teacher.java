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

//    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
//    private Set<FeedBack> feedbacks;

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

//    public Set<FeedBack> getFeedbacks() {
//		return feedbacks;
//	}
//
//	public void setFeedbacks(Set<FeedBack> feedbacks) {
//		this.feedbacks = feedbacks;
//	}

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
}
