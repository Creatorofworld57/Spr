package ex.springsecurity_1805;

import ex.springsecurity_1805.Models.Usermain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usermain,Long> {

Optional<Usermain> findByName(String username);


}
