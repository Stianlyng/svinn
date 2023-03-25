package ntnu.idatt2105.stianlyng.svinn.repositories;

import ntnu.idatt2105.stianlyng.svinn.entities.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {

}