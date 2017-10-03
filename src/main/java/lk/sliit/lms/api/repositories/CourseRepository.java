package lk.sliit.lms.api.repositories;

import lk.sliit.lms.api.models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dinukshakandasamanage on 9/23/17.
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
}
