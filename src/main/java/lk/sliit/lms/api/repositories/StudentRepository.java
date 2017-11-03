package lk.sliit.lms.api.repositories;

import lk.sliit.lms.api.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Consists all the student related CRUD operations done to the DB
 *
 * Created by dinukshakandasamanage on 9/23/17.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findByEmail(String email);
}
