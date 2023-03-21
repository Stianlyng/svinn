package ntnu.idatt2105.stianlyng.svinn.repository;

import org.springframework.data.repository.CrudRepository;

import ntnu.idatt2105.stianlyng.svinn.model.Demo;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DemoRepository extends CrudRepository<Demo, Integer> {

}