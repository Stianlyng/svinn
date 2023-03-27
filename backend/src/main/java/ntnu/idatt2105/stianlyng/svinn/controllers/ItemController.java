package ntnu.idatt2105.stianlyng.svinn.controllers;

import ntnu.idatt2105.stianlyng.svinn.DTO.ItemRequestDTO;
import ntnu.idatt2105.stianlyng.svinn.entities.Bookmark;
import ntnu.idatt2105.stianlyng.svinn.entities.Item;
import ntnu.idatt2105.stianlyng.svinn.services.BookmarkService;
import ntnu.idatt2105.stianlyng.svinn.services.ItemService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private BookmarkService bookmarkService;
    
    /**
     * Creates a new item
     * 
     * @param itemRequest
     * @return
     */
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody ItemRequestDTO itemRequest) {
        Item newItem = itemService.createItem(itemRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
    
    @GetMapping("/user")
    public ResponseEntity<List<Item>> getAllItemsByUser() {
        List<Item> items = itemService.getAllItemsByUser();
        return ResponseEntity.ok(items);
    }
   
    @GetMapping("/user/bookmarks")
    public ResponseEntity<List<Item>> getAllBookmarksByUser() {
        List<Bookmark> bookmarks = bookmarkService.getAllBookmarks();
        List<Item> items = new ArrayList<Item>();
        for (Bookmark bookmark : bookmarks) {
           Item item = itemService.getItem(bookmark.getId());
              items.add(item); 
        }
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Integer id) {
        Item item = itemService.getItem(id);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Integer itemId) {
        itemService.deleteItem(itemId);
        return ResponseEntity.noContent().build();
    }


    //todo; consider adding a child that extends ItemRequestDTO, and add the id there..
    @PutMapping("/{itemId}")
    public ResponseEntity<Item> updateItem(@PathVariable Integer itemId, @RequestBody ItemRequestDTO itemRequest) {
        Item updatedItem = itemService.updateItem(itemId, itemRequest);
        return ResponseEntity.ok(updatedItem);
    }
    
}