package ntnu.idatt2105.stianlyng.svinn.repositories;

import ntnu.idatt2105.stianlyng.svinn.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Additional custom queries can be added here
}
