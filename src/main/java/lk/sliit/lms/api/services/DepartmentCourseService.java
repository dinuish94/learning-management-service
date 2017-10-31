package lk.sliit.lms.api.services;

import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.models.Department;
import lk.sliit.lms.api.repositories.CourseRepository;
import lk.sliit.lms.api.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nuwani on 10/28/2017.
 */
@Service
public class DepartmentCourseService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    CourseRepository courseRepository;

    public Course mapCoursesToDepartment(Long dId, Long cId){

        Department department = departmentRepository.findOne(dId);
        Course course = courseRepository.findOne(cId);

        course.setDepartment(department);
        return courseRepository.save(course);
    }
}
