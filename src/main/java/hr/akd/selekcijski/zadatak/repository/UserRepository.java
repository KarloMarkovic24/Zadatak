package hr.akd.selekcijski.zadatak.repository;

import hr.akd.selekcijski.zadatak.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
