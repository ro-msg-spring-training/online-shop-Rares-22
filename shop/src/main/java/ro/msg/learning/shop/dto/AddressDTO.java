package ro.msg.learning.shop.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private String address_country;
    private String address_city;
    private String address_county;
    private String address_street_address;
}
