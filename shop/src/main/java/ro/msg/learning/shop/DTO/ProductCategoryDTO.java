package ro.msg.learning.shop.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.model.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductCategoryDTO extends BaseEntity {
    private String name;
    private String description;

}
