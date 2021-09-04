package codegym.repository;

import codegym.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepo extends CrudRepository<User,Long> {
    User findByUser_name(String name);
}
