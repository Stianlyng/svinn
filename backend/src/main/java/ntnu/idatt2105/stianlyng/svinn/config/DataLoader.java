package ntnu.idatt2105.stianlyng.svinn.config;

// Entities
import ntnu.idatt2105.stianlyng.svinn.entities.Category;
import ntnu.idatt2105.stianlyng.svinn.entities.Item;
import ntnu.idatt2105.stianlyng.svinn.entities.Location;
import ntnu.idatt2105.stianlyng.svinn.entities.Bookmark;
import ntnu.idatt2105.stianlyng.svinn.entities.Message;
import ntnu.idatt2105.stianlyng.svinn.entities.Role;
import ntnu.idatt2105.stianlyng.svinn.entities.User;
// Repositories
import ntnu.idatt2105.stianlyng.svinn.repositories.CategoryRepository;
import ntnu.idatt2105.stianlyng.svinn.repositories.ItemRepository;
import ntnu.idatt2105.stianlyng.svinn.repositories.LocationRepository;
import ntnu.idatt2105.stianlyng.svinn.repositories.MessageRepository;
import ntnu.idatt2105.stianlyng.svinn.repositories.UserRepository;
import ntnu.idatt2105.stianlyng.svinn.repositories.BookmarkRepository;

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
        //loadBookmarks();
        //loadMessages();
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
                new User(null, "Stian", "Lyng", "a@a.a", "aaaa", Role.USER, null),
                new User(null, "Jane", "Doe", "jane.doe@example.com", "password", Role.USER, null)
        );
        userRepository.saveAll(users);
    }
   
    private void loadItems() {
        Location location = locationRepository.findById(1).orElse(null);
        User user = userRepository.findById(1).orElse(null);
        Category category = categoryRepository.findById(2).orElse(null);
        
        List<Item> items = Arrays.asList(
                new Item(null, "Invisible Glasses", "The perfect pair of glasses to see things that don't exist.", 100, LocalDateTime.now(), LocalDateTime.now(), category, location, user),
                new Item(null, "Time Machine", "Travel through time with our slightly malfunctioning time machine. Results may vary.", 100, LocalDateTime.now(), LocalDateTime.now(), category, location, user),
                new Item(null, "Telepathic TV", "Watch your favorite shows without a remote! Warning: May change channels based on your mood.", 100, LocalDateTime.now(), LocalDateTime.now(), category, location, user),
                new Item(null, "Alien Perfume", "Smell out of this world with our exclusive extraterrestrial fragrance.", 100, LocalDateTime.now(), LocalDateTime.now(), category, location, user),
                new Item(null, "Cloud Catcher", "Tired of sunny days? Catch your own personal cloud to follow you around.", 100, LocalDateTime.now(), LocalDateTime.now(), category, location, user),
                new Item(null, "Self-Playing Piano", "No musical talent? No problem! This piano plays itself, just sit back and enjoy.", 100, LocalDateTime.now(), LocalDateTime.now(), category, location, user),
                new Item(null, "Unicorn Slippers", "Feel magical every morning by slipping your feet into these cozy unicorn slippers.", 100, LocalDateTime.now(), LocalDateTime.now(), category, location, user),
                new Item(null, "Anti-Gravity Hat", "Defy gravity with this stylish hat. Warning: May cause sudden floating.", 100, LocalDateTime.now(), LocalDateTime.now(), category, location, user),
                new Item(null, "Eternal Ice Cream", "Satisfy your sweet tooth with our never-melting, always-delicious ice cream.", 100, LocalDateTime.now(), LocalDateTime.now(), category, location, user),
                new Item(null, "Giggle Gloves", "Brighten your day with these gloves that let out a giggle every time you give a high-five.", 100, LocalDateTime.now(), LocalDateTime.now(), category, location, user)
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