package pl.psomocnik.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.psomocnik.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    public Role findByName(String name);
}
