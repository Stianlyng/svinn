package ntnu.idatt2105.stianlyng.svinn.repositories;

import ntnu.idatt2105.stianlyng.svinn.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}