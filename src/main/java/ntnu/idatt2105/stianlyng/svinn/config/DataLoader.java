package ntnu.idatt2105.stianlyng.svinn.config;

// Entities
import ntnu.idatt2105.stianlyng.svinn.entities.Category;
import ntnu.idatt2105.stianlyng.svinn.entities.Item;
import ntnu.idatt2105.stianlyng.svinn.entities.Location;
import ntnu.idatt2105.stianlyng.svinn.entities.Bookmark;
import ntnu.idatt2105.stianlyng.svinn.entities.Message;
import ntnu.idatt2105.stianlyng.svinn.user.Role;
import ntnu.idatt2105.stianlyng.svinn.user.User;

// Repositories
import ntnu.idatt2105.stianlyng.svinn.repositories.CategoryRepository;
import ntnu.idatt2105.stianlyng.svinn.repositories.ItemRepository;
import ntnu.idatt2105.stianlyng.svinn.repositories.LocationRepository;
import ntnu.idatt2105.stianlyng.svinn.repositories.MessageRepository;
import ntnu.idatt2105.stianlyng.svinn.repositories.BookmarkRepository;
import ntnu.idatt2105.stianlyng.svinn.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
@Profile("!test") // Exclude this data loader in the "test" profile
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ItemRepository itemRepository;
    
    @Autowired
    private BookmarkRepository bookmarkRepository;
    
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadLocations();
        loadUsers();
        loadItems();
        loadBookmarks();
        loadMessages();
    }


    private void loadCategories() {
        List<Category> categories = Arrays.asList(
                new Category(null, "Electronics", "Electronic devices and gadgets"),
                new Category(null, "Clothing", "Apparel and fashion"),
                new Category(null, "Home & Garden", "Home improvement and gardening items"),
                new Category(null, "Sports & Outdoors", "Sporting goods and outdoor equipment")
        );
        categoryRepository.saveAll(categories);
    }
    
    private void loadLocations() {
        List<Location> locations = Arrays.asList(
                new Location(null, "Trondheim", 2.2, 3.2)
        );
        locationRepository.saveAll(locations);
    }

    private void loadUsers() {
        List<User> users = Arrays.asList(
                new User(null, "John", "Doe", "john.doe@example.com", "password", Role.USER, null),
                new User(null, "Jane", "Doe", "jane.doe@example.com", "password", Role.USER, null)
        );
        userRepository.saveAll(users);
    }
   
    private void loadItems() {
        Location location = locationRepository.findById(1).orElse(null);
        User user = userRepository.findById(1).orElse(null);
        Category category = categoryRepository.findById(2).orElse(null);
        
        List<Item> items = Arrays.asList(
                new Item(null, "sofa", "dritnice sofa", 100, LocalDateTime.now(),LocalDateTime.now(), category,location,user),
                new Item(null, "sofaking", "enda nicere sofa", 100, LocalDateTime.now(),LocalDateTime.now(), category,location,user)
        );
        itemRepository.saveAll(items);

    }
    private void loadBookmarks() {

        User user = userRepository.findById(1).orElse(null);
        Item item = itemRepository.findById(1).orElse(null);
        Item item2 = itemRepository.findById(2).orElse(null);

        List<Bookmark> bookmarks = Arrays.asList(
                new Bookmark(null, user,item),
                new Bookmark(null, user,item2)
        );
        bookmarkRepository.saveAll(bookmarks);
    }
    
    private void loadMessages() {
        User user = userRepository.findById(1).orElse(null);
        User user2 = userRepository.findById(2).orElse(null);
        Item item = itemRepository.findById(1).orElse(null);

        List<Message> messages = Arrays.asList(
                new Message(null,"hi dude, like ur sofa!",LocalDateTime.now(),user,user2,item)
        );
        messageRepository.saveAll(messages);
    }
}