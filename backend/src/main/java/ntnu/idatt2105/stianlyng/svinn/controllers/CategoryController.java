package ntnu.idatt2105.stianlyng.svinn.controllers;

import ntnu.idatt2105.stianlyng.svinn.entities.Category;
import ntnu.idatt2105.stianlyng.svinn.services.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lombok.AllArgsConstructor;

/**
 * Controller class for managing category-related requests.
 */
@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

   /**
    * Creates a new category using the provided Category instance.
    *
    * @param category the Category instance to be created
    * @return ResponseEntity containing the created Category instance
    */
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(createdCategory);
    }
    
   /**
    * Retrieves all categories.
    *
    * @return ResponseEntity containing a list of all Category instances
    */
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

   /**
    * Deletes a category with the specified ID.
    *
    * @param categoryId the ID of the category to be deleted
    * @return ResponseEntity with an empty body and a No Content (204) status code
    */
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer categoryId) { // todo; consider @RequestBody
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }
    
  /**
    * Updates a category with the specified ID using the provided Category instance.
    *
    * @param categoryId the ID of the category to be updated
    * @param updatedCategory the Category instance containing the updated information
    * @return ResponseEntity containing the updated Category instance
    */ 
    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer categoryId, @RequestBody Category updatedCategory) {
        Category category = categoryService.updateCategory(categoryId, updatedCategory);
        return ResponseEntity.ok(category);
    }
}