package ro.msg.learning.shop.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.Product;

import java.security.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrderDTO {
    public Timestamp timestamp;
    public AddressDTO address;
    public List<OrderDetail> products;

}
