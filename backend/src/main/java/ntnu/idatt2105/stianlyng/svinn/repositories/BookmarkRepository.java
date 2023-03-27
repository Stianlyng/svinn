package ntnu.idatt2105.stianlyng.svinn.repositories;

import ntnu.idatt2105.stianlyng.svinn.entities.Bookmark;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {

        List<Bookmark> findByUserId(Integer userId);
        
        List<Bookmark> findByItemId(Integer itemId);
        
        List<Bookmark> findByUserIdAndItemId(Integer userId, Integer itemId);
}