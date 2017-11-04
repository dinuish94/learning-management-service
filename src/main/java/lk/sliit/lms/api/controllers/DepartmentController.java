package lk.sliit.lms.api.controllers;

import java.util.Set;
import java.util.*;

import lk.sliit.lms.api.dto.DepartmentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;

import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.models.Department;
import lk.sliit.lms.api.models.Teacher;
import lk.sliit.lms.api.repositories.CourseRepository;
import lk.sliit.lms.api.repositories.DepartmentRepository;
import lk.sliit.lms.api.repositories.StudentRepository;
import lk.sliit.lms.api.repositories.TeacherRepository;
import lk.sliit.lms.api.services.DepartmentService;
import lk.sliit.lms.api.services.TeacherService;

import javax.validation.Valid;
/**
 * Created by nuwani on 10/28/2017.
 *
 * Controller class for department
 * Consists of end points to retrieve department related data
 */

@Controller
@RequestMapping (path = "/departments")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    //to get all the department details
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody()
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    //Retrieve a Single Department
    @RequestMapping(value ="/{departmentID}", method = RequestMethod.GET)
    @ResponseBody()
    public Department getDepartment(@PathVariable("departmentID") String departmentID){
        return departmentService.getDepartment(departmentID);
    }

    //add a new department
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody()
    public Department createDepartment(@Valid @RequestBody DepartmentDTO department){

        return departmentService.createDepartment(department);
    }

//    //delete a department
//    @RequestMapping(value = "/departments/{id}", method = RequestMethod.DELETE)
//    @ResponseBody()
//    public ResponseEntity<Department> deleteDepartment ( Long dId){
//        Department department = departmentRepository.findOne(dId);
//        if(department == null){
//            return ResponseEntity.notFound().build();
//        }
//        departmentRepository.delete(department);
//        return ResponseEntity.ok().build();
//    }

    //delete a department
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody()
    public void deleteDepartment(@Valid @RequestBody Long dId){
        departmentService.deleteDepartment(dId);
    }

}
