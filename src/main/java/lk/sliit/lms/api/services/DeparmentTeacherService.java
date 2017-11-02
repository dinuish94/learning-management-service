package lk.sliit.lms.api.services;

import lk.sliit.lms.api.models.Department;
import lk.sliit.lms.api.models.Teacher;
import lk.sliit.lms.api.repositories.DepartmentRepository;
import lk.sliit.lms.api.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nuwani on 10/28/2017.
 */
@Service
public class DeparmentTeacherService{

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public Teacher mapTeacherToDepartment(Long dId, Long tId){

        Department department = departmentRepository.findOne(dId);
        Teacher teacher = teacherRepository.findOne(tId);

        teacher.setDepartment(department);

        return teacherRepository.save(teacher);
    }
}
