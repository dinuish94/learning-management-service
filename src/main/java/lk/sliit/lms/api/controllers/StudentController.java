package lk.sliit.lms.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jonathan on 9/26/2017.
 */
@RestController
public class StudentController {

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getAllStudents(){
        return "{\"name\":\"Jona\"}";
    }
}
