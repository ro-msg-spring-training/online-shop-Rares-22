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
@Table(name="LOCATION")
public class Location extends BaseEntity{
    private String name;
    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreetAddress;
}
