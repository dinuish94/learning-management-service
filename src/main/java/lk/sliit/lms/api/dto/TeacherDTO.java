package lk.sliit.lms.api.dto;

/**
 * Created by kashifroshen on 11/1/17.
 */
public class TeacherDTO {
    long departmentId;
    String name;

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeacherDTO(long departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }

    public TeacherDTO() {

    }
}
