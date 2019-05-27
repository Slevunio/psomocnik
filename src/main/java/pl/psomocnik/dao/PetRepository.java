package pl.psomocnik.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.psomocnik.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
