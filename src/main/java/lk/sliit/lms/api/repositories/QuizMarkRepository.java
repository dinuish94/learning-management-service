package lk.sliit.lms.api.repositories;

import lk.sliit.lms.api.models.Quiz;
import lk.sliit.lms.api.models.QuizMark;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kashifroshen on 10/21/17.
 */
public interface QuizMarkRepository extends CrudRepository<QuizMark, Long> {
    List<QuizMark> findByQuiz(Quiz quiz);
}
