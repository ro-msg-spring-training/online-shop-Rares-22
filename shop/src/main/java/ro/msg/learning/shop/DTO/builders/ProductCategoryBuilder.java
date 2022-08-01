
package ro.msg.learning.shop.DTO.builders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTO.ProductCategoryDTO;
import ro.msg.learning.shop.model.Category;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class ProductCategoryBuilder {
    public ProductCategoryDTO toDTO(Category productCategory) {
        Integer id = productCategory.getId();
        String name = productCategory.getName();
        String description = productCategory.getDescription();
        return new ProductCategoryDTO( name, description);
    }

    public Category toProductCategory(ProductCategoryDTO productCategoryDTO) {
        return new Category(productCategoryDTO.getName(), productCategoryDTO.getDescription());
    }
}