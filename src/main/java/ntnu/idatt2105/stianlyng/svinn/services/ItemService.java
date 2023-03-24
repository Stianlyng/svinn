package ntnu.idatt2105.stianlyng.svinn.services;

import ntnu.idatt2105.stianlyng.svinn.entities.Item;
import ntnu.idatt2105.stianlyng.svinn.repositories.ItemRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public void deleteItem(Integer itemId) {
        itemRepository.deleteById(itemId);
    }

    public Item updateItem(Integer itemId, Item updatedItem) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        item.setBriefDescription(updatedItem.getBriefDescription());
        item.setFullDescription(updatedItem.getFullDescription());
        item.setCategory(updatedItem.getCategory());
        item.setLocation(updatedItem.getLocation());
        item.setPrice(updatedItem.getPrice());
        item.setUser(updatedItem.getUser());
        item.setCreatedAt(updatedItem.getCreatedAt());
        item.setUpdatedAt(updatedItem.getUpdatedAt());
    
        return itemRepository.save(item);
    }
}