package lk.sliit.lms.api.repositories;

import lk.sliit.lms.api.models.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by nuwani on 10/28/2017.
 */
@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long>{
}
