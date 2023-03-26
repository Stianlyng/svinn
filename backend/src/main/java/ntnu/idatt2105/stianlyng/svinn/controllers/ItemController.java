package ntnu.idatt2105.stianlyng.svinn.controllers;

import ntnu.idatt2105.stianlyng.svinn.DTO.CreateItemDTO;
import ntnu.idatt2105.stianlyng.svinn.DTO.ItemRequestDTO;
import ntnu.idatt2105.stianlyng.svinn.entities.Category;
import ntnu.idatt2105.stianlyng.svinn.entities.Item;
import ntnu.idatt2105.stianlyng.svinn.entities.Location;
import ntnu.idatt2105.stianlyng.svinn.entities.Role;
import ntnu.idatt2105.stianlyng.svinn.entities.User;
import ntnu.idatt2105.stianlyng.svinn.repositories.CategoryRepository;
import ntnu.idatt2105.stianlyng.svinn.repositories.LocationRepository;
import ntnu.idatt2105.stianlyng.svinn.repositories.UserRepository;
import ntnu.idatt2105.stianlyng.svinn.services.ItemService;
import ntnu.idatt2105.stianlyng.svinn.services.JwtService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;
    
    //@Autowired
    //private JwtService jwtService;

    //@Autowired
    //private LocationRepository locationRepository;

    //@Autowired
    //private UserRepository userRepository;

    //@Autowired
    //private CategoryRepository categoryRepository;
    
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

    //@DeleteMapping("/{itemId}")
    //public ResponseEntity<Void> deleteItem(@PathVariable Integer itemId) {
    //    itemService.deleteItem(itemId);
    //    return ResponseEntity.noContent().build();
    //}

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