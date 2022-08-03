package ro.msg.learning.shop.model;

import lombok.Data;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass

public class BaseEntity {
    @Id
    private Integer id;
}
