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

/**
 * Controller class for handling Item-related requests, such as creation, deletion, and updating.
 */
@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private BookmarkService bookmarkService;

    /**
     * Creates a new Item object by handeling POST requests to /api/v1/items.
     * 
     * @param itemRequest an ItemRequestDTO object representing the item's information
     * @return a response enity with the new item and a status code
     */
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody ItemRequestDTO itemRequest) {
        Item newItem = itemService.createItem(itemRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
    }

    /**
     * Gets all items by handeling GET requests to /api/v1/items.
     * 
     * @return ResponseEntity with a list of all items and a status code.
     */
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
    
    /**
     * Gets all items belonging to the current user by handeling GET requests to /api/v1/items/user.
     * 
     * @return ResponseEntity with a list of all items belonging to the current user and a status code.
     */
    @GetMapping("/user")
    public ResponseEntity<List<Item>> getAllItemsByUser() {
        List<Item> items = itemService.getAllItemsByUser();
        return ResponseEntity.ok(items);
    }
   
    /**
     * Gets all items bookmarked by the current user by handeling GET requests to /api/v1/items/user/bookmarks.
     * 
     * @return ResponseEntity with a list of all items bookmarked by the current user and a status code.
     */
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

    /**
     * Get an item by its ID by handeling GET requests to /api/v1/items/{id}.
     * 
     * @param id an Integer representing the ID of the item to be retrieved
     * @return ResponseEntity with a list of all items and a status code.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Integer id) {
        Item item = itemService.getItem(id);
        return ResponseEntity.ok(item);
    }

    /**
     * Deletes an item by its ID by handeling DELETE requests to /api/v1/items/{itemId}.
     * 
     * @param itemId an Integer representing the ID of the item to be deleted
     * @return ResponseEntity with a status code indicating success or failure of the deletion attempt
     */
    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Integer itemId) {
        itemService.deleteItem(itemId);
        return ResponseEntity.noContent().build();
    }


    //todo; consider adding a child that extends ItemRequestDTO, and add the id there..
    /**
     * Updates an item by its ID by handeling PUT requests to /api/v1/items/{itemId}.
     *
     * @param itemId
     * @param itemRequest
     * @return ResponseEntity with a status code indicating success or failure of the update attempt
     */
    @PutMapping("/{itemId}")
    public ResponseEntity<Item> updateItem(@PathVariable Integer itemId, @RequestBody ItemRequestDTO itemRequest) {
        Item updatedItem = itemService.updateItem(itemId, itemRequest);
        return ResponseEntity.ok(updatedItem);
    }
    
}