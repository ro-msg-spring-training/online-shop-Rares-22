package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="CUSTOMER")
public class Customer extends BaseEntity{

    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String email;

}
