package pl.psomocnik.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.psomocnik.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}

