package si.um.ris.repository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import si.um.ris.models.AppUser;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface IAppUserRepo extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
    Optional<AppUser> findUserByUsername(String username);
}
