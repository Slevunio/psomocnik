package pl.psomocnik.dao;

import pl.psomocnik.model.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Long> {
    List<Pet> findAllById(List<Long> id);
}
