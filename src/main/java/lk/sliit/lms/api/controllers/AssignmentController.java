package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.dto.AssignmentDTO;
import lk.sliit.lms.api.dto.AssignmentUploadDTO;
import lk.sliit.lms.api.models.Assignment;
import lk.sliit.lms.api.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by dinukshakandasamanage on 10/22/17.
 */

@RestController
@RequestMapping(path = "/assignments")
@CrossOrigin(origins = "http://localhost:4200")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

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
        System.out.println("Controller");
        System.out.println(Long.parseLong(assignId));
      //  return ResponseEntity.status(HttpStatus.CREATED).build();
        AssignmentUploadDTO assignmentDTO = new AssignmentUploadDTO();
        assignmentDTO.setAssignId(Long.parseLong(assignId));
        assignmentDTO.setsId(Long.parseLong(sId));
        String fileLocation=assignmentService.store(file);
        assignmentDTO.setFile(fileLocation);
        return assignmentService.uploadAssignmentDetails(assignmentDTO);
    }

}
