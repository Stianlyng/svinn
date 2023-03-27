package ntnu.idatt2105.stianlyng.svinn.controllers;

import ntnu.idatt2105.stianlyng.svinn.entities.Bookmark;
import ntnu.idatt2105.stianlyng.svinn.services.BookmarkService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing bookmark-related requests.
 */
@RestController
@RequestMapping("/api/v1/bookmarks")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    //@PostMapping
    //public ResponseEntity<Bookmark> createBookmark(@RequestBody Bookmark bookmark) {
    //    Bookmark createdBookmark = bookmarkService.createBookmark(bookmark);
    //    return ResponseEntity.ok(createdBookmark);
    //}

   /**
    * Creates a new bookmark using the provided item ID.
    *
    * @param itemId the ID of the item to be bookmarked
    * @return ResponseEntity containing the created Bookmark instance
    */
    @PostMapping("/{itemId}")
    public ResponseEntity<Bookmark> createBookmarkByItemID(@PathVariable int itemId) {
        Bookmark createdBookmark = bookmarkService.createBookmarkByItemID(itemId);
        return ResponseEntity.ok(createdBookmark);
    }

  /**
    * Retrieves all bookmarks.
    *
    * @return ResponseEntity containing a list of all Bookmark instances
    */
    @GetMapping
    public ResponseEntity<List<Bookmark>> getAllBookmarks() {
        List<Bookmark> bookmarks = bookmarkService.getAllBookmarks();
        return ResponseEntity.ok(bookmarks);
    }

   /**
    * Deletes a bookmark with the specified ID.
    *
    * @param bookmarkId the ID of the bookmark to be deleted
    * @return ResponseEntity with an empty body and a No Content (204) status code
    */
    @DeleteMapping("/{bookmarkId}")
    public ResponseEntity<Void> deleteBookmark(@PathVariable Integer bookmarkId) {
        bookmarkService.deleteBookmark(bookmarkId);
        return ResponseEntity.noContent().build();
    }

}