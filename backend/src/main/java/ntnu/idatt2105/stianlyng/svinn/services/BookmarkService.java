package ntnu.idatt2105.stianlyng.svinn.services;

import ntnu.idatt2105.stianlyng.svinn.entities.Bookmark;
import ntnu.idatt2105.stianlyng.svinn.repositories.BookmarkRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private UserService userService;

    public Bookmark createBookmark(Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }
    
    public Bookmark createBookmarkByItemID(int itemId) {
        Bookmark bookmark = new Bookmark();
        bookmark.setId(itemId);
        bookmark.setUser(userService.getAuthenticatedUser());
        return bookmarkRepository.save(bookmark);
    }

    public List<Bookmark> getAllBookmarks() {
        int user = userService.getAuthenticatedUser().getId();
        return bookmarkRepository.findByUserId(user);
    }

    public void deleteBookmark(Integer bookmarkId) {
        bookmarkRepository.deleteById(bookmarkId);
    }
}