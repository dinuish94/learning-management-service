package lk.sliit.lms.api.repositories;

import lk.sliit.lms.api.models.Feedback;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jonathan on 11/1/2017.
 */
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
}
