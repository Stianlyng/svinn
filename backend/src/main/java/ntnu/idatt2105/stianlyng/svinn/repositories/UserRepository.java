package ntnu.idatt2105.stianlyng.svinn.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import ntnu.idatt2105.stianlyng.svinn.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}
