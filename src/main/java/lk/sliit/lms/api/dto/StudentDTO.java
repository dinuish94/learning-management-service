package lk.sliit.lms.api.dto;

/**
 * Created by kashifroshen on 11/3/17.
 */
public class StudentDTO {
    Long studentId;
    String name;
    String email;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StudentDTO(String name,String email) {
        this.name = name;
        this.email = email;
    }

    public StudentDTO() {

    }
}
