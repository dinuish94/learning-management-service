package lk.sliit.lms.api.repositories;

import lk.sliit.lms.api.models.Course;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dinukshakandasamanage on 9/23/17.
 */
public interface CourseRepository extends CrudRepository<Course, Long> {
}
