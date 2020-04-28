package space.dubovitsky.portfolio.repository;

import org.springframework.data.repository.CrudRepository;
import space.dubovitsky.portfolio.entity.ProfileRestore;

public interface ProfileRestoreRepository extends CrudRepository<ProfileRestore, Long> {

    ProfileRestore findByToken(String token);
}
