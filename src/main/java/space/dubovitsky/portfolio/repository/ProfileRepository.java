package space.dubovitsky.portfolio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import space.dubovitsky.portfolio.entity.Profile;

import java.sql.Timestamp;
import java.util.List;

public interface ProfileRepository extends PagingAndSortingRepository<Profile, Long> {

    Profile findByUid(String uid);

    Profile findByEmail(String email);

    Profile findByPhone(String phone);

    int countByUid(String uid);

    Page<Profile> findAllByCompletedTrue(Pageable pageable);

    //* Ищем всех пользователей, которые не заполнили свой профиль
    List<Profile> findByCompletedFalseAndCreatedBefore(Timestamp timestamp);

}
