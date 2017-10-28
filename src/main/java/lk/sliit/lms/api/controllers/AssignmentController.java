package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.dto.AssignmentDTO;
import lk.sliit.lms.api.models.Assignment;
import lk.sliit.lms.api.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    @ResponseBody
    public Assignment getAssignmentById(@PathVariable("id") Long assignId){
        return assignmentService.getAssignmentById(assignId);
    }

    @PutMapping("/{id}")
    public Assignment updateAssignmentById(@PathVariable("id") Long assignId, @RequestBody AssignmentDTO assignmentDTO){
        return assignmentService.updateAssignment(assignId, assignmentDTO);

    }
}
