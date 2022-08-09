package ro.msg.learning.shop.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Map;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name="PRODUCT_ORDER")

public class ProductOrder extends BaseEntity{

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime created_at;
    private String address_country;
    private String address_city;
    private String address_county;
    private String address_street_address;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location shipped_from;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Transient
    private Map<Integer,Integer> products;
}
