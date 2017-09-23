package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.models.Teacher;
import lk.sliit.lms.api.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller class for teacher
 * Consists of endpoints to retrieve teacher related data
 *
 * Created by dinukshakandasamanage on 9/23/17.
 */
@Controller
@RequestMapping(path = "/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/")
    @ResponseBody
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

}
