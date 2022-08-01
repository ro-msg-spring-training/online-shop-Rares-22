package ro.msg.learning.shop.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreetAddress;
}
