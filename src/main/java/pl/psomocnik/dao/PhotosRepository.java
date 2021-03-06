package pl.psomocnik.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.psomocnik.model.Photo;

import java.util.List;

@Repository
public interface PhotosRepository extends CrudRepository<Photo,Long> {
    public List<Photo> findByPetId(Long petId);
    public List<Photo> findAllByOrderByIdAsc();
}
