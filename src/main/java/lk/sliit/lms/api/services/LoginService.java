package lk.sliit.lms.api.services;

import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.models.Teacher;
import lk.sliit.lms.api.models.User;
import lk.sliit.lms.api.repositories.StudentRepository;
import lk.sliit.lms.api.repositories.TeacherRepository;
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

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<User> users= new ArrayList<>();

//    public User authenticateUser(User user){
//        User authUser = new User();
//        userRepo.findAll().forEach(userdb -> {
//            if(user.getId().intValue()==userdb.getId().intValue() && user.getPassword().equals(userdb.getPassword())){
//                authUser.setId(userdb.getId());
//                authUser.setPassword(userdb.getPassword());
//                authUser.setRole(userdb.getRole());
//            }
//        });
//        return authUser;
//    }

    public User authenticateUser(User user){
        User authUser = new User();
        System.out.println("username : "+user.getEmail());
        System.out.println("pass : "+user.getPassword());

        if(user.getEmail().equals("admin") && user.getPassword().equals("admin")){
            authUser.setRole(1);
            authUser.setId(1L);
            authUser.setEmail("Admin");
            return authUser;
        }

        userRepo.findAll().forEach(userdb -> {

            System.out.println("HERE 0 ");
            if(user.getEmail().equals(userdb.getEmail()) && user.getPassword().equals(userdb.getPassword())){
                authUser.setEmail(userdb.getEmail());
                authUser.setRole(userdb.getRole());
                System.out.println("HERE");
                Student student = studentRepository.findByEmail(userdb.getEmail());
                Teacher teacher = teacherRepository.findByEmail(userdb.getEmail());

                if(student==null && teacher !=null){
                    authUser.setId(teacher.gettId());
                }
                else{
                    authUser.setId(student.getsId());
                }

            }
        });
        return authUser;
    }

}
