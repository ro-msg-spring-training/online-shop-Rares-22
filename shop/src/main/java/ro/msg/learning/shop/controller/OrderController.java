package ro.msg.learning.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.model.ProductOrder;
import ro.msg.learning.shop.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/{customerID}")
    private OrderDTO createOrder(@PathVariable Integer customerID, @RequestBody OrderDTO orderDTO) {
        ProductOrder order = orderService.mapToEntity(orderDTO);
        return orderService.mapToDTO(orderService.createOrder(customerID, order));
    }

    @GetMapping("/get")
    public List<OrderDTO> getAllOrders(){
        return orderService.getAllOrders()
                .stream()
                .map(this.orderService::mapToDTO)
                .collect(Collectors.toList());
    }
}