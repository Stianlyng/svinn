package ntnu.idatt2105.stianlyng.svinn.config;

// Entities
import ntnu.idatt2105.stianlyng.svinn.entities.Category;

// Repositories
import ntnu.idatt2105.stianlyng.svinn.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Profile("!test") // Exclude this data loader in the "test" profile
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
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
}