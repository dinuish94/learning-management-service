package lk.sliit.lms.api.services;

import lk.sliit.lms.api.dto.AssignmentDTO;
import lk.sliit.lms.api.models.Assignment;
import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.repositories.AssignmentRepository;
import lk.sliit.lms.api.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinukshakandasamanage on 10/22/17.
 */

@Service
public class AssignmentService {

    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    CourseRepository courseRepository;

    public List<Assignment> getAllAssignments(){

        List<Assignment> assignments = new ArrayList<>();
        assignmentRepository.findAll().forEach(assignment -> {
            assignments.add(assignment);
        });
        return assignments;
    }

    public Assignment addAssignment(AssignmentDTO assignmentDTO){
        Assignment newAssignment = new Assignment();
        newAssignment.setName(assignmentDTO.getName());
        newAssignment.setDescription(assignmentDTO.getDescription());
        newAssignment.setStartDate(assignmentDTO.getStartDate());
        newAssignment.setEndDate(assignmentDTO.getEndDate());

        Course course = courseRepository.findOne(assignmentDTO.getCourseId());
        newAssignment.setCourse(course);

        return assignmentRepository.save(newAssignment);
    }

    public List<Assignment> getAllAssignmentsForCourse(Long courseId){
        Course course = courseRepository.findOne(courseId);
        List<Assignment> assignments = new ArrayList<>();
        course.getAssignments().forEach(assignment -> assignments.add(assignment));
        return assignments;
    }
}
