package lk.sliit.lms.api.services;

import lk.sliit.lms.api.dto.CourseDTO;
import lk.sliit.lms.api.dto.TeacherDTO;
import lk.sliit.lms.api.models.Department;
import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.models.Teacher;
import lk.sliit.lms.api.repositories.DepartmentRepository;
import lk.sliit.lms.api.models.User;
import lk.sliit.lms.api.repositories.TeacherRepository;
import lk.sliit.lms.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Handles all the teacher related operations
 * <p>
 * Created by dinukshakandasamanage on 9/23/17.
 */

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    UserRepository userRepository;


    /**
     * Retrieves all teachers and maps them to Teacher objects
     *
     * @return all teachers
     */
    public Iterable<Teacher> getAllTeachers() {

        return teacherRepository.findAll();
    }

    /***
     * get details of a teacher
     *
     * @return teacher
     */
    public Teacher getTeacher (Long teacherID) {

        return teacherRepository.findOne(teacherID);
    }

    /**
     * create a new teacher
     */
    public Teacher createTeacher(TeacherDTO teacherDTO){

        Teacher teacher = new Teacher();

        teacher.setName(teacherDTO.getName());
        teacher.setEmail(teacherDTO.getEmail());

        return teacherRepository.save(teacher);
    }
    /**
     * delete a new teacher
     */
    public void deleteTeacher(Long tId){
        Teacher teacher = teacherRepository.findOne(tId);
        teacherRepository.delete(teacher);
    }

    public List<CourseDTO> getCoursesForTeacher(Long id) {
        Teacher teacher = teacherRepository.findOne(id);
        List<CourseDTO> courseDTOS = new ArrayList<>();
        teacher.getCourses().forEach(course -> {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setName(course.getName());
            courseDTO.setDescription(course.getDescription());
            courseDTO.setTitle(course.getTitle());
            courseDTO.setcId(course.getcId());
            courseDTOS.add(courseDTO);
        });

        return courseDTOS;
    }
}
