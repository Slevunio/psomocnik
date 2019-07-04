package pl.psomocnik.dao;

import pl.psomocnik.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
