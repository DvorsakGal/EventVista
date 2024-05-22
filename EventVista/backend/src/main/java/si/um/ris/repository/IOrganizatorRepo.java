package si.um.ris.repository;

import org.springframework.data.repository.CrudRepository;
import si.um.ris.models.Organizator;

import java.util.List;

public interface IOrganizatorRepo extends CrudRepository<Organizator, Long> {
    Organizator findByIme(String ime);

    List<Organizator> findByIdLessThanAndIme(int i, String jan);
}
