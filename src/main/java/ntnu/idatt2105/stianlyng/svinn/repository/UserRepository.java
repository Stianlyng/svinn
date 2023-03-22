package ntnu.idatt2105.stianlyng.svinn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ntnu.idatt2105.stianlyng.svinn.model.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);
}