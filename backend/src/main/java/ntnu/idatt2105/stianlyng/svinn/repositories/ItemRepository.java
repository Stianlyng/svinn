package ntnu.idatt2105.stianlyng.svinn.repositories;

import ntnu.idatt2105.stianlyng.svinn.entities.Item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Integer> {

        List<Item> findByUserId(Long userId);
        
        @Query("SELECT i FROM Item i WHERE i.user.email = :email")
        List<Item> findByEmail(@Param("email") String email);

}