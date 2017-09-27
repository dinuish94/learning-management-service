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
    public List<User> users= new ArrayList<>();

    public User authenticateUser(User user){
        User authUser = new User();
        userRepo.findAll().forEach(userdb -> {
            if(user.getId().intValue()==userdb.getId().intValue() && user.getPassword().equals(userdb.getPassword())){
                authUser.setId(userdb.getId());
                authUser.setPassword(userdb.getPassword());
                authUser.setRole(userdb.getRole());
            }
        });
        return authUser;
    }

}
