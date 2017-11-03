package lk.sliit.lms.api.repositories;

import lk.sliit.lms.api.models.StudentAssignment;
import lk.sliit.lms.api.models.StudentAssignmentPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dinukshakandasamanage on 10/23/17.
 */

@Repository
public interface StudentAssignmentRepository extends CrudRepository<StudentAssignment, StudentAssignmentPK>{

}
