package lk.sliit.lms.api.repositories;

import lk.sliit.lms.api.models.Quiz;
import lk.sliit.lms.api.models.QuizMark;
import lk.sliit.lms.api.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kashifroshen on 10/21/17.
 */
public interface QuizMarkRepository extends CrudRepository<QuizMark, Long> {

    List<QuizMark> findByStudent(Student student);
    List<QuizMark> findByQuiz(Quiz quiz);

}
