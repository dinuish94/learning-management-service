package test;


import lk.sliit.lms.api.models.Assignment;
import lk.sliit.lms.api.models.Course;
import lk.sliit.lms.api.repositories.AssignmentRepository;
import lk.sliit.lms.api.repositories.CourseRepository;
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

import java.util.ArrayList;
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
    }

    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private CourseRepository courseRepository;

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
    }

    @After
    public void verify() {
        Mockito.verify(assignmentRepository, VerificationModeFactory.times(1)).findAll();
        Mockito.reset(assignmentRepository);
//        Mockito.verify(courseRepository, VerificationModeFactory.times(1)).findOne(Mockito.anyLong());
//        Mockito.reset(assignmentRepository);
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