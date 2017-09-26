package lk.sliit.lms.api.services;

import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 9/26/2017.
 */
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepo;

    private List<Student> students = new ArrayList<>();

    public List<Student> getAllStudents(){
        students.clear();
        studentRepo.findAll().forEach(course->{
            students.add(course);
        });
        System.out.println(students);
        return  students;
    }

    public Student getCourse(String studentId){
        long id = Long.parseLong(studentId);
        Student student = studentRepo.findOne(id);
        return student;
    }
}
