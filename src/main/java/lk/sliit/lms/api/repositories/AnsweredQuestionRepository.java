package lk.sliit.lms.api.repositories;

import lk.sliit.lms.api.models.AnsweredQuestion;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kashifroshen on 10/23/17.
 */
public interface AnsweredQuestionRepository extends CrudRepository<AnsweredQuestion, Long> {
}
