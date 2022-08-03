
package ro.msg.learning.shop.dto.builders;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductCategoryDTO;
import ro.msg.learning.shop.model.Category;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Supplier;

@Component
@RequiredArgsConstructor
@Builder
public class ProductCategoryBuilder {
    public static ProductCategoryDTO returnDtoFromEntity (Product product){
        return ProductCategoryDTO.builder().category_id(product.getId())
                .category_name(product.getCategory().getName())
                .product_id(product.getId())
                .product_name(product.getName())
                .product_description(product.getDescription())
                .product_price(product.getPrice())
                .product_weight(product.getWeight())
                .image_url(product.getImage_url())
                .supplier_id(product.getSupplier().getId())
                .supplier_name(product.getSupplier().getName())
                .build();
    }

    public static Product returnEntityFromDto (ProductCategoryDTO productDto, Supplier supplier, Category productCategory){
        return Product.builder()
                .name(productDto.getProduct_name())
                .image_url(productDto.getImage_url())
                .description(productDto.getProduct_description())
                .supplier(supplier)
                .weight(productDto.getProduct_weight())
                .price(productDto.getProduct_price())
                .category(productCategory)
                .build();
    }
}