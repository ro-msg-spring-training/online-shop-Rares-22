package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exception.ProductCategoryException;
import ro.msg.learning.shop.exception.ProductNotFoundException;
import ro.msg.learning.shop.model.Category;
import ro.msg.learning.shop.repository.ICategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final ICategoryRepository categoryRepository;

    public void saveProductCategory(Category productCategory) {
        categoryRepository.save(productCategory);
    }

    public List<Category> findAllProductCategories() {
        return categoryRepository.findAll();
    }


    public void deleteProductCategory(Integer categoryId) {
        if (categoryRepository.existsById(categoryId)) {
            categoryRepository.deleteById(categoryId);
        } else {

        }
    }

    public Category findByName(String name) {
        return categoryRepository.findProductCategoryByName(name)
                .orElseThrow(() -> new ProductCategoryException("There is no product with this category"));
    }


    public void deleteAll() {
        categoryRepository.deleteAll();
    }
}
