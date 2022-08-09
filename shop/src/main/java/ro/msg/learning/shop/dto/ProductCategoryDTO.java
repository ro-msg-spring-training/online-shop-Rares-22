package ro.msg.learning.shop.dto;

import lombok.*;
import ro.msg.learning.shop.model.BaseEntity;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Builder

public class ProductCategoryDTO extends BaseEntity {

    private Integer product_id;
    private String product_name;
    private String product_description;
    private BigDecimal product_price;
    private Double product_weight;
    private String image_url;
    private Integer supplier_id;
    private String supplier_name;
    private Integer category_id;
    private String category_name;
    private String category_description;

}
