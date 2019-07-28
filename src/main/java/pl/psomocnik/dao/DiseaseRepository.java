package pl.psomocnik.dao;

import org.springframework.data.repository.CrudRepository;
import pl.psomocnik.model.Disease;

import java.util.UUID;

public interface DiseaseRepository extends CrudRepository <Disease, Long> {
}
