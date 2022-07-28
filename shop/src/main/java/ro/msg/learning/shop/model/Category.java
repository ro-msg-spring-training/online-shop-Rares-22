package ro.msg.learning.shop.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import static javax.persistence.CascadeType.REMOVE;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="CATEGORY")
public class Category extends BaseEntity{

    private String name;
    private String description;


}
