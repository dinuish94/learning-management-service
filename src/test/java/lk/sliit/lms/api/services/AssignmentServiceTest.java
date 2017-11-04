package lk.sliit.lms.api.services;


import lk.sliit.lms.api.dto.AssignmentDTO;
import lk.sliit.lms.api.models.Assignment;
import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.repositories.AssignmentRepository;
import lk.sliit.lms.api.repositories.CourseRepository;
import lk.sliit.lms.api.repositories.StudentAssignmentRepository;
import lk.sliit.lms.api.repositories.StudentRepository;
import lk.sliit.lms.api.services.AssignmentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by dinukshakandasamanage on 11/2/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AssignmentServiceTest {

    @Configuration
    static class AssignmentServiceTestContextConfiguration {
        @Bean
        public AssignmentService assignmentService() {
            return new AssignmentService();
        }

        @Bean
        public AssignmentRepository assignmentRepository() {
            return Mockito.mock(AssignmentRepository.class);
        }

        @Bean
        public CourseRepository courseRepository() {
            return Mockito.mock(CourseRepository.class);
        }

        @Bean
        public StudentRepository studentRepository() {
            return Mockito.mock(StudentRepository.class);
        }

        @Bean
        public StudentAssignmentRepository studentAssignmentRepository() {
            return Mockito.mock(StudentAssignmentRepository.class);
        }

        @Bean
        public ServletContext servletContext() {
            return Mockito.mock(ServletContext.class);
        }
    }

    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentAssignmentRepository studentAssignmentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ServletContext servletContext;

    @Before
    public void setUp() throws Exception {
        List<Assignment> assignments = new ArrayList<>();
        Assignment assignment1 = new Assignment();
        assignment1.setName("assignment1");
        assignment1.setDescription("This is assignment 1 description");
        Assignment assignment2 = new Assignment();
        assignment2.setName("assignment2");
        assignment2.setDescription("This is assignment 2 description");
        assignments.add(assignment1);
        assignments.add(assignment2);

        Course course = new Course();
        course.setName("SE1");

        Mockito.when(assignmentRepository.findAll()).thenReturn(assignments);
        Mockito.when(courseRepository.findOne(Mockito.anyLong())).thenReturn(course);
        Mockito.when(assignmentRepository.save(Mockito.any(Assignment.class))).thenReturn(assignment1);
    }

    @After
    public void verify() {
//        Mockito.verify(assignmentRepository, VerificationModeFactory.times(1)).findAll();
        Mockito.reset(assignmentRepository);
        Mockito.reset(courseRepository);
    }

    @Test
    public void getAllAssignments() throws Exception {
        List<Assignment> assignments = assignmentService.getAllAssignments();
        assertEquals("assignment1", assignments.get(0).getName());
        assertEquals("This is assignment 1 description", assignments.get(0).getDescription());
        assertEquals("assignment2",assignments.get(1).getName());
        assertEquals("This is assignment 2 description", assignments.get(1).getDescription());
    }

    @Test
    public void addAssignment() throws Exception {
        AssignmentDTO assignmentDTO = new AssignmentDTO();
        assignmentDTO.setName("Assign1");
        assignmentDTO.setDescription("Desc");
        assignmentDTO.setStartDate(new Date());
        assignmentDTO.setEndDate(new Date());
        assignmentDTO.setCourseId(1L);
        Assignment assignment = assignmentService.addAssignment(assignmentDTO);
        assertEquals("assignment1",assignment.getName());
    }

    @Test
    public void getAllAssignmentsForCourse() throws Exception {

    }

    @Test
    public void getAssignmentById() throws Exception {

    }

    @Test
    public void updateAssignment() throws Exception {

    }

}