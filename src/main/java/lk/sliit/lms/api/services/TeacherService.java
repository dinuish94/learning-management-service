package lk.sliit.lms.api.services;

import lk.sliit.lms.api.dto.TeacherDTO;
import lk.sliit.lms.api.models.Department;
import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.models.Teacher;
import lk.sliit.lms.api.repositories.DepartmentRepository;
import lk.sliit.lms.api.repositories.TeacherRepository;
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

        Department department = departmentRepository.findOne(teacherDTO.getDepartmentId());

        Teacher teacher = new Teacher(department,teacherDTO.getName());

        return teacherRepository.save(teacher);
    }
    /**
     * delete a new teacher
     */
    public void deleteTeacher(Long tId){
        Teacher teacher = teacherRepository.findOne(tId);
        teacherRepository.delete(teacher);
    }
}
