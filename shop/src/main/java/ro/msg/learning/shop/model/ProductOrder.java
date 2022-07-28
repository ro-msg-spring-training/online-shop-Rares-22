package ro.msg.learning.shop.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

@Table(name="PRODUCTORDER")

public class ProductOrder extends BaseEntity{

    private Date createdAt;
    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreetAddress;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location shippedFrom;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
