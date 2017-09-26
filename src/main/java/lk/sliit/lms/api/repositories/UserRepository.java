package lk.sliit.lms.api.repositories;

import lk.sliit.lms.api.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jonathan on 9/26/2017.
 */
public interface UserRepository extends CrudRepository<User, Long>{
}
