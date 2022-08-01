package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.Category;
import ro.msg.learning.shop.repository.ICategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private static final String ERROR_MESSAGE = "category not found for the id ";
    private final ICategoryRepository CategoryRepository;

    public void saveProductCategory(Category productCategory) {
        CategoryRepository.save(productCategory);
    }

    public List<Category> findAllProductCategories() {
        return CategoryRepository.findAll();
    }

    //public Optional<Category> findProductCategoryById(final Integer id) {
//        return Optional.ofNullable(CategoryRepository.findById(id).orElseThrow(
//                //() -> new ProductCategoryException(ERROR_MESSAGE + id)));
    //}

    public void deleteProductCategory(Integer categoryId) {
        if (CategoryRepository.existsById(categoryId)) {
            CategoryRepository.deleteById(categoryId);
        } else {
            //throw (new CategoryException(ERROR_MESSAGE + categoryId));
        }
    }
}
