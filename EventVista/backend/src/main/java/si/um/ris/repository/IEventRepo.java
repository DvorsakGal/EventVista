package si.um.ris.repository;

import org.springframework.data.repository.CrudRepository;
import si.um.ris.models.Event;

public interface IEventRepo extends CrudRepository<Event, Long> {

}
