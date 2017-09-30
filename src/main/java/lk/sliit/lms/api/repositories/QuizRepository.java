package lk.sliit.lms.api.repositories;

import lk.sliit.lms.api.models.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Handles the QuizDTO related CRUD operations
 *
 * Created by dinukshakandasamanage on 9/23/17.
 */
@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {
}
