package repositories;

import models.User;

public interface UsersRepository extends CrudRepository<User> {
    User findByLogin(String login);
}
