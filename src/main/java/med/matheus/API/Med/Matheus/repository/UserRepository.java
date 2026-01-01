package med.matheus.API.Med.Matheus.repository;

import med.matheus.API.Med.Matheus.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String username);
}
