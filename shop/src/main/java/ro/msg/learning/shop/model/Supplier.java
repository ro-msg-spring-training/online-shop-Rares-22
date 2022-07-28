package ro.msg.learning.shop.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="SUPPLIER")

public class Supplier extends BaseEntity{
    private String name;

}
