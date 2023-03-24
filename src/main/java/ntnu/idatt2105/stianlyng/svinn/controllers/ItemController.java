package ntnu.idatt2105.stianlyng.svinn.controllers;

import ntnu.idatt2105.stianlyng.svinn.entities.Item;
import ntnu.idatt2105.stianlyng.svinn.services.ItemService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item createdItem = itemService.createItem(item);
        return ResponseEntity.ok(createdItem);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Integer itemId) {
        itemService.deleteItem(itemId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<Item> updateItem(@PathVariable Integer itemId, @RequestBody Item updatedItem) {
        Item item = itemService.updateItem(itemId, updatedItem);
        return ResponseEntity.ok(item);
    }
}