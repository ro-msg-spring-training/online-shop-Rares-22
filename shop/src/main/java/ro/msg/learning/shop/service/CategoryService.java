package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.Category;
import ro.msg.learning.shop.repository.ICategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final ICategoryRepository CategoryRepository;

    public void saveProductCategory(Category productCategory) {
        CategoryRepository.save(productCategory);
    }

    public List<Category> findAllProductCategories() {
        return CategoryRepository.findAll();
    }


    public void deleteProductCategory(Integer categoryId) {
        if (CategoryRepository.existsById(categoryId)) {
            CategoryRepository.deleteById(categoryId);
        } else {

        }
    }
}
