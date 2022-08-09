package ro.msg.learning.shop.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="REVENUE")

public class Revenue extends BaseEntity{

    private Date data_revenue;
    private BigDecimal sum;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
