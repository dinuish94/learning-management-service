package lk.sliit.lms.api.services;

import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.models.Teacher;
import lk.sliit.lms.api.models.User;
import lk.sliit.lms.api.repositories.TeacherRepository;
import lk.sliit.lms.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    UserRepository userRepository;

    /**
     * Retrieves all teachers and maps them to Teacher objects
     *
     * @return all teachers
     */
    public Set<Teacher> getAllTeachers() {

        Set<Teacher> teachers = new HashSet<>();

        teacherRepository.findAll().forEach(teacher -> {
            Teacher retrievedTeacher = new Teacher();
            retrievedTeacher.setName(teacher.getName());
            retrievedTeacher.setId(teacher.getId());
            teachers.add(teacher);
        });

        teacherRepository.save(new Teacher());

        return teachers;
    }

    /***
     * get details of a teacher
     *
     * @return teacher
     */
    public Teacher getTeacher (String teacherID) {

        Long id = Long.parseLong(teacherID);
        Teacher teacher = teacherRepository.findOne(id);
        return teacher;
    }

    /**
     * create a new teacher
     */
    public Teacher createTeacher(Teacher teacher){

        User t = new User();
        t.setEmail(teacher.getEmail());
        t.setPassword("123");
        t.setRole(2);
        userRepository.save(t);


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
