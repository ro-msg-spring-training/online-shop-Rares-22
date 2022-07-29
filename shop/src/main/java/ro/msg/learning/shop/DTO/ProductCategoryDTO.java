package ro.msg.learning.shop.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data

public class ProductCategoryDTO {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;
    private String imageUrl;

}
