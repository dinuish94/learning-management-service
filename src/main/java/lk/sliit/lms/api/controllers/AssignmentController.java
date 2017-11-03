package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.dto.AssignmentDTO;
import lk.sliit.lms.api.dto.AssignmentUploadDTO;
import lk.sliit.lms.api.dto.StudentAssignmentDTO;
import lk.sliit.lms.api.dto.SubmissionDTO;
import lk.sliit.lms.api.models.Assignment;
import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.models.StudentAssignment;
import lk.sliit.lms.api.services.AssignmentService;
import lk.sliit.lms.api.services.StudentService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by dinukshakandasamanage on 10/22/17.
 */

@RestController
@RequestMapping(path = "/assignments")
@CrossOrigin(origins = "*")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    @ResponseBody()
    public List<Assignment> getAllAssignments(){
        return assignmentService.getAllAssignments();
    }

    @PostMapping("/")
    @ResponseBody
    public Assignment addNewAssignment(@RequestBody AssignmentDTO assignmentDTO){
        return assignmentService.addAssignment(assignmentDTO);
    }

    @PostMapping("/student")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam String assignId, @RequestParam String sId) {
        AssignmentUploadDTO assignmentDTO = new AssignmentUploadDTO();
        assignmentDTO.setAssignId(Long.parseLong(assignId));
        assignmentDTO.setsId(Long.parseLong(sId));
        String fileLocation=assignmentService.store(file);
        assignmentDTO.setFile(fileLocation);
        return assignmentService.uploadAssignmentDetails(assignmentDTO);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Assignment getAssignmentById(@PathVariable("id") Long assignId){
        return assignmentService.getAssignmentById(assignId);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Assignment updateAssignmentById(@PathVariable("id") Long assignId, @RequestBody AssignmentDTO assignmentDTO){
        return assignmentService.updateAssignment(assignId, assignmentDTO);

    }

    @PostMapping("{id}/marks")
    @ResponseBody
    public void assignGradeForAssignment(@RequestBody StudentAssignmentDTO studentAssignmentDTO){
        assignmentService.assignGrade(studentAssignmentDTO);
    }

    @PostMapping("{id}/feedback")
    @ResponseBody
    public void addFeedbackForAssignment(@RequestBody StudentAssignmentDTO studentAssignmentDTO){
        assignmentService.addFeedback(studentAssignmentDTO);
    }

    @GetMapping("student-assignments/{id}")
    @ResponseBody
    public List<SubmissionDTO> getAllSubmissionsForStudent(@PathVariable("id") Long assignId){
        return studentService.getAllStudentAssignments(assignId);
    }

    @RequestMapping(value = "student-assignments/{id}/file", produces = { "application/json" })
    public @ResponseBody ResponseEntity getFile(@RequestParam(value="fileName", required=false) String fileName) throws IOException {

        ResponseEntity respEntity = uploadFile(fileName);
        return respEntity;
    }

    @PostMapping("/materials")
    public ResponseEntity<String> uploadAssignment(@RequestParam("file") MultipartFile file, @RequestParam String assignId) {
        AssignmentUploadDTO assignmentDTO = new AssignmentUploadDTO();
        assignmentDTO.setAssignId(Long.parseLong(assignId));
        String fileLocation=assignmentService.storeAssignment(file);
        assignmentDTO.setFile(fileLocation);
        return assignmentService.uploadAssignmentMaterial(assignmentDTO);
    }

    @RequestMapping(value = "materials/file", produces = { "application/json" })
    public @ResponseBody ResponseEntity getAssignmentFile(@RequestParam(value="fileName", required=false) String fileName) throws IOException {

        ResponseEntity respEntity = uploadFile(fileName);
        return respEntity;
    }

    private ResponseEntity uploadFile(@RequestParam(value = "fileName", required = false) String fileName) throws IOException {
        ResponseEntity respEntity = null;

        byte[] reportBytes = null;
        File result=new File(fileName);

        if(result.exists()){
            InputStream inputStream = new FileInputStream(fileName);
            String type=result.toURL().openConnection().guessContentTypeFromName(fileName);

            byte[] out = IOUtils.toByteArray(inputStream);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("content-disposition", "attachment; filename=" + fileName);
            responseHeaders.add("Content-Type",type);

            respEntity = new ResponseEntity(out, responseHeaders, HttpStatus.OK);
        }else{
            respEntity = new ResponseEntity ("File Not Found", HttpStatus.OK);
        }
        return respEntity;
    }


}
