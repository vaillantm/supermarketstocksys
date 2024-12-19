package finalproject.finalproject.service;

import finalproject.finalproject.model.Category;
import finalproject.finalproject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Find a category by name
    public Category findCategoryByCategoryname(String categoryname) {
        return categoryRepository.findByCategoryname(categoryname);
    }

    // Save or update a category
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Get category by ID
    public Optional<Category> findCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId);
    }

    // Delete category by ID
    public void deleteCategoryById(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
