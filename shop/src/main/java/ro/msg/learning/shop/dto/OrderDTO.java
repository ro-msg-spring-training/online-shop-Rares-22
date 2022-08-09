package ro.msg.learning.shop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.model.OrderDetail;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class OrderDTO {

    private Integer id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime create_at;
    private String address_country;
    private String address_city;
    private String address_county;
    private String address_street_address;
    private Map<Integer, Integer> products;
}
