package ntnu.idatt2105.stianlyng.svinn.controllers;

import ntnu.idatt2105.stianlyng.svinn.DTO.ItemRequestDTO;
import ntnu.idatt2105.stianlyng.svinn.entities.Item;
import ntnu.idatt2105.stianlyng.svinn.services.ItemService;

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

    //@PutMapping("/{itemId}")
    //public ResponseEntity<Item> updateItem(@PathVariable Integer itemId, @RequestBody Item updatedItem) {
    //    Item item = itemService.updateItem(itemId, updatedItem);
    //    return ResponseEntity.ok(item);
    //}
    //
    //@GetMapping("/user")
    //public ResponseEntity<List<Item>> getAllItemsByLoggedInUser(@RequestHeader("Authorization") String authHeader) {
    //    String token = authHeader.replace("Bearer ", "");
    //    System.out.println(token);
    //    String email = jwtService.extractUsername(token); // Assuming email is used as the username
    //    System.out.println(email);
    //    
    //    List<Item> items = itemService.getAllItemsByEmail("a@a.a");
    //    return ResponseEntity.ok(items);
    //}
    
}