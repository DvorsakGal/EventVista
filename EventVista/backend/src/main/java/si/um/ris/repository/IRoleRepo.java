package si.um.ris.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import si.um.ris.models.Role;

import java.util.Optional;

@Repository
public interface IRoleRepo extends CrudRepository<Role, Long> {
    Optional<Role> findByAuthority(String authority);
}
