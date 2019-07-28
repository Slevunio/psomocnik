package pl.psomocnik.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.psomocnik.model.Photo;

@Repository
public interface PhotosRepository extends CrudRepository<Photo,Long> {
}
