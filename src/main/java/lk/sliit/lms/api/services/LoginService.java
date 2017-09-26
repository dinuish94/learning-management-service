package lk.sliit.lms.api.services;

import lk.sliit.lms.api.models.User;
import lk.sliit.lms.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 9/26/2017.
 */
@Service
public class LoginService {

    @Autowired
    UserRepository userRepo;

    User authUser;

    public List<User> users= new ArrayList<>();

    public User authenticateUser(User user){

        userRepo.findAll().forEach(userdb -> {
            if(user.getId()==userdb.getId() && user.getPassword().equals(userdb.getPassword())){
                authUser = new User();
                authUser.setId(userdb.getId());
                authUser.setPassword(userdb.getPassword());
                authUser.setRole(userdb.getRole());
            }
        });
        return authUser;
    }

}
