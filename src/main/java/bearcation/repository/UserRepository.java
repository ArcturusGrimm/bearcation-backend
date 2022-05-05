package bearcation.repository;

import bearcation.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndPasswordAndRole(String email, String password, String role);

    Optional<User> findUserById(Long id);

    Optional<User> findByFirstNameAndEmail(String firstName, String email);


}
