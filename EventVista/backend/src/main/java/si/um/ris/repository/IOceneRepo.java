package si.um.ris.repository;

import org.springframework.data.repository.CrudRepository;
import si.um.ris.models.Ocena;

public interface IOceneRepo extends CrudRepository<Ocena, Long> {

}
