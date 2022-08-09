
package ro.msg.learning.shop.dto.builders;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductCategoryDTO;
import ro.msg.learning.shop.model.Category;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Supplier;

@Component
@RequiredArgsConstructor
@Builder
public class ProductCategoryBuilder {
    private static ModelMapper modelMapper;

    public static ProductCategoryDTO returnDtoFromEntity(Product product){
        ProductCategoryDTO productCategoryDTO = modelMapper.map(product,ProductCategoryDTO.class);
        return productCategoryDTO;
    }

    public static Product returnEntityFromDto(ProductCategoryDTO productCategoryDTO){
        Product product = modelMapper.map(productCategoryDTO,Product.class);
        return product;
    }
}