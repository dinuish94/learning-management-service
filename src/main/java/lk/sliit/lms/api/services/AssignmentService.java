package lk.sliit.lms.api.services;

import lk.sliit.lms.api.dto.AssignmentDTO;
import lk.sliit.lms.api.dto.AssignmentUploadDTO;
import lk.sliit.lms.api.dto.StudentAssignmentDTO;
import lk.sliit.lms.api.models.*;
import lk.sliit.lms.api.repositories.AssignmentRepository;
import lk.sliit.lms.api.repositories.CourseRepository;
import lk.sliit.lms.api.repositories.StudentAssignmentRepository;
import lk.sliit.lms.api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by dinukshakandasamanage on 10/22/17.
 */

@Service
public class AssignmentService {

    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentAssignmentRepository studentAssignmentRepository;

    @Autowired
    ServletContext context;


    private final Path rootLocation = Paths.get("upload-dir");

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

    public ResponseEntity<String> uploadAssignmentDetails(AssignmentUploadDTO assignmentDTO){
        System.out.println("Assignment Service");
        System.out.println("Student ID : "+assignmentDTO.getsId());
        System.out.println("Assignment ID : "+assignmentDTO.getAssignId());

        Assignment assignment = assignmentRepository.findOne(assignmentDTO.getAssignId());
        Student student = studentRepository.findOne(assignmentDTO.getsId());
        System.out.println("Retrievd Student ID : "+student.getsId());

        StudentAssignment studentAssignment = new StudentAssignment();
        studentAssignment.setStudent(student);
        studentAssignment.setAssignment(assignment);
        studentAssignment.setFile(assignmentDTO.getFile());

        System.out.println("Student assign : ");
        System.out.println(studentAssignment.getStudent().getsId());

        studentAssignmentRepository.save(studentAssignment);
        student.getStudentAssignment().add(studentAssignment);
        studentRepository.save(student);


        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public String store(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("src/main/java/lk/sliit/lms/api/assignments", file.getOriginalFilename());
            //  Path path = Paths.get(rootLocation+file.getOriginalFilename());
            // Path path = Paths.get(context.getRealPath("uploads") + file.getOriginalFilename());
            Files.write(path, bytes);
            return path.toString();
        } catch (Exception e) {
            System.out.println(file);
            throw new RuntimeException("FAIL!", e);
        }
    }

    public ResponseEntity<String> uploadAssignmentMaterial(AssignmentUploadDTO assignmentDTO){

        Assignment assignment = assignmentRepository.findOne(assignmentDTO.getAssignId());
        assignment.setFile(assignmentDTO.getFile());
        assignmentRepository.save(assignment);


        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public String storeAssignment(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("src/main/java/lk/sliit/lms/api/files", file.getOriginalFilename());
            Files.write(path, bytes);
            return path.toString();
        } catch (Exception e) {
            System.out.println(file);
            throw new RuntimeException("FAIL!", e);
        }
    }
      
    public Assignment getAssignmentById(Long assignmentId){
        return assignmentRepository.findOne(assignmentId);
    }

    public Assignment updateAssignment(Long assignId, AssignmentDTO assignmentDTO) {
        Assignment assignment = assignmentRepository.findOne(assignId);
        assignment.setName(assignmentDTO.getName());
        assignment.setDescription(assignmentDTO.getDescription());
        assignment.setStartDate(assignmentDTO.getStartDate());
        assignment.setEndDate(assignmentDTO.getEndDate());
        return assignmentRepository.save(assignment);
    }

    public void assignGrade(StudentAssignmentDTO studentAssignmentDTO) {

        studentAssignmentRepository.findAll().forEach(assignment -> {
            if(assignment.getStudent().getsId().equals(studentAssignmentDTO.getStudentId())
                    && assignment.getAssignment().getAssignId().equals(studentAssignmentDTO.getAssignId())){
                assignment.setMarks(studentAssignmentDTO.getMarks());
                studentAssignmentRepository.save(assignment);
            }
        });
    }

    public void addFeedback(StudentAssignmentDTO studentAssignmentDTO) {
        studentAssignmentRepository.findAll().forEach(assignment -> {
            if(assignment.getStudent().getsId().equals(studentAssignmentDTO.getStudentId())
                    && assignment.getAssignment().getAssignId().equals(studentAssignmentDTO.getAssignId())){
                assignment.setFeedback(studentAssignmentDTO.getFeedback());
                studentAssignmentRepository.save(assignment);
            }
        });
    }
}
