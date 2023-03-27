package ntnu.idatt2105.stianlyng.svinn.repositories;

import ntnu.idatt2105.stianlyng.svinn.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}