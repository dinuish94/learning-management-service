package lk.sliit.lms.api.services;

import lk.sliit.lms.api.dto.DepartmentDTO;
import org.springframework.stereotype.Service;
import lk.sliit.lms.api.models.Department;

import lk.sliit.lms.api.repositories.CourseRepository;
import lk.sliit.lms.api.repositories.DepartmentRepository;
import lk.sliit.lms.api.repositories.StudentRepository;
import lk.sliit.lms.api.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by nuwani on 10/28/2017.
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TeacherRepository teacherRepository;


    /**
     * Retrieves all departments and maps them to Department objects
     *
     * @return all teachers
     */

//	public Set<Department> getAllDepartments(){
//
//		Set<Department> departments = new HashSet<>();
//
//		departmentRepository.findAll().forEach(department -> {
//			Department retrievedDepartment = new Department();
//			retrievedDepartment.setName(department.getName());
//			retrievedDepartment.setdId(department.getdId());
//			retrievedDepartment.setCourses(department.getCourses());
//			departments.add(department);
//		});
//		return departments;
//  }

    public List<Department> departments = new ArrayList<>();

    public List<Department> getAllDepartments(){

        departments.clear();
        departmentRepository.findAll().forEach(department ->{
            departments.add(department);
        });
        System.out.println(departments);
        return departments;
    }

    public Department getCourse (String courseID){

        Long id = Long.parseLong(courseID);
        Department department = departmentRepository.findOne(id);
        return department;
    }

    public Department getStudents(String studentID){

        Long id = Long.parseLong(studentID);
        Department department = departmentRepository.findOne(id);
        return department;
    }

    public Set<Department> getAllDepartmentDetails(){

        Set<Department> departments = new HashSet<>();

        departmentRepository.findAll().forEach(department -> {
            Department retrievedDepartment = new Department();
            retrievedDepartment.setName(department.getName());
            retrievedDepartment.setdId(department.getdId());
            retrievedDepartment.setDescription(department.getDescription());
            retrievedDepartment.setCourses(department.getCourses());
            departments.add(department);
        });
        return departments;
    }

    public Department getDepartment (String departmentID){

        Long did = Long.parseLong(departmentID);
        Department department = departmentRepository.findOne(did);
        return department;
    }

    public Department createDepartment (DepartmentDTO departmentDTO){

        Set li = new HashSet();

        Department department = new Department(departmentDTO.getName(),departmentDTO.getDescription(),li,li,li);
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long dId){

        Department department = departmentRepository.findOne(dId);
        departmentRepository.delete(department);
    }
}
