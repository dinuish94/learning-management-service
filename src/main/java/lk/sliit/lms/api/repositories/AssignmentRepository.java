package lk.sliit.lms.api.repositories;

import lk.sliit.lms.api.models.Assignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dinukshakandasamanage on 10/22/17.
 */

@Repository
public interface AssignmentRepository extends CrudRepository<Assignment, Long> {
}
