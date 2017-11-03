package lk.sliit.lms.api.dto;

import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.models.Teacher;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by kashifroshen on 11/1/17.
 */
public class DepartmentDTO {

    private String name;

    private String description;

    private int[] courses;

    private int[] teachers;

    private int[] students;

    public DepartmentDTO(String name, String description, int[] courses, int[] teachers, int[] students) {
        this.name = name;
        this.description = description;
        this.courses = courses;
        this.teachers = teachers;
        this.students = students;
    }

    public DepartmentDTO() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int[] getCourses() {
        return courses;
    }

    public void setCourses(int[] courses) {
        this.courses = courses;
    }

    public int[] getTeachers() {
        return teachers;
    }

    public void setTeachers(int[] teachers) {
        this.teachers = teachers;
    }

    public int[] getStudents() {
        return students;
    }

    public void setStudents(int[] students) {
        this.students = students;
    }
}
