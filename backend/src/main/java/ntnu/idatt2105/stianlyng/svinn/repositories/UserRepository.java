package ntnu.idatt2105.stianlyng.svinn.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ntnu.idatt2105.stianlyng.svinn.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}