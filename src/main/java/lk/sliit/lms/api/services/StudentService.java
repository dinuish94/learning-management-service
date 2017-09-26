package lk.sliit.lms.api.services;

import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;
import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.models.Enrollment;
import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.repositories.CourseRepository;
import lk.sliit.lms.api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Jonathan on 9/26/2017.
 */
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepo;

    @Autowired
    CourseRepository courseRepo;

    private List<Student> students = new ArrayList<>();

    public List<Student> getAllStudents(){
        students.clear();
        studentRepo.findAll().forEach(student->{
            students.add(student);
        });
        System.out.println(students);
        return  students;
    }

    public Student getCourse(String studentId){
        long id = Long.parseLong(studentId);
        Student student = studentRepo.findOne(id);
        return student;
    }

    public void enroll(Enrollment enrollment){

        Student student = studentRepo.findOne(enrollment.getsId());
        Course course = courseRepo.findOne(enrollment.getcId());
        course.getStudents().add(student);
        courseRepo.save(course);
//        studentRepo.save(student);

//        course.setStudents(new HashSet<Student>(){{
//            add(student);
//        }});
//        courseRepo.save(course);

    }

    public void unEnroll(Enrollment enrollment){

        Student student = studentRepo.findOne(enrollment.getsId());
        Course course = courseRepo.findOne(enrollment.getcId());
        course.getStudents().remove(student);
        courseRepo.save(course);

    }
}
