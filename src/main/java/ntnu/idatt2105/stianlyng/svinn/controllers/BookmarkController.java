package ntnu.idatt2105.stianlyng.svinn.controllers;

import ntnu.idatt2105.stianlyng.svinn.entities.Bookmark;
import ntnu.idatt2105.stianlyng.svinn.services.BookmarkService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookmarks")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping
    public ResponseEntity<Bookmark> createBookmark(@RequestBody Bookmark bookmark) {
        Bookmark createdBookmark = bookmarkService.createBookmark(bookmark);
        return ResponseEntity.ok(createdBookmark);
    }

    @GetMapping
    public ResponseEntity<List<Bookmark>> getAllBookmarks() {
        List<Bookmark> bookmarks = bookmarkService.getAllBookmarks();
        return ResponseEntity.ok(bookmarks);
    }

    @DeleteMapping("/{bookmarkId}")
    public ResponseEntity<Void> deleteBookmark(@PathVariable Integer bookmarkId) {
        bookmarkService.deleteBookmark(bookmarkId);
        return ResponseEntity.noContent().build();
    }

}