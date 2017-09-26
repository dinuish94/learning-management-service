package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.models.User;
import lk.sliit.lms.api.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jonathan on 9/26/2017.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public User authenticate(@Validated @RequestBody User user){
        return loginService.authenticateUser(user);
    }
}

