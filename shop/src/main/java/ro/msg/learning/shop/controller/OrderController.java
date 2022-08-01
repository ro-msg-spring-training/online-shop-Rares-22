package ro.msg.learning.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/order")
public class OrderController {
//    private final OrderService orderService;
//    private final ProductService productService;
//    private final CustomerService customerService;
//
//    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
//    @Transactional
//    public ResponseEntity<?> creteOrder(@RequestBody ProductOrderDTO orderDTOView) {
//        try {
//            Map<Product, Integer> productQuantity = orderDTOView.getProductsList().stream()
//                    .collect(Collectors.toMap(x -> productService.readById(x.getProductId()), ProductOrderDto::getQuantity));
//            ProductOrder order = ProductOrder.builder().city(orderDTOView.getCity()).country(orderDTOView.getCountry()).createAt(orderDTOView.getTimestamp()).streetAddress(orderDTOView.getStreetAddress()).county(orderDTOView.getCounty()).customer(customerService.findById(1)).build();
//
//            List<OrdersDto> ordersDtos = orderService.createOrder(productQuantity, order).stream()
//                    .map(o -> OrdersDto.builder().id(o.getId()).city(o.getCity()).country(o.getCountry()).county(o.getCounty()).streetAddress(o.getStreetAddress()).createAt(o.getCreateAt()).customerId(o.getCustomer().getId()).customerName(o.getCustomer().getFirstName() + o.getCustomer().getLastName()).locationId(o.getLocation().getId()).locationName(o.getLocation().getName()).build())
//                    .collect(Collectors.toList());
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Created", MediaType.APPLICATION_JSON_VALUE);
//            return ResponseEntity.accepted().headers(headers).body(ordersDtos);
//        } catch (StrategyException | NoObjectFoundException e) {
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Not created", MediaType.APPLICATION_JSON_VALUE);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(e.getMessage());
//        }

//    }

}