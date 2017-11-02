package lk.sliit.lms.api.services;

import lk.sliit.lms.api.models.Department;
import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.repositories.DepartmentRepository;
import lk.sliit.lms.api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nuwani on 10/28/2017.
 */
@Service
public class DepartmentStudentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    StudentRepository studentRepository;

    public Student mapStudentToCourse(Long dId, Long sId){

        Department department = departmentRepository.findOne(dId);
        Student student = studentRepository.findOne(sId);

        student.setDepartment(department);
        return studentRepository.save(student);
    }
}
