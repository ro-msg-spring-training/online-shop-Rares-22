package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.ProductCategoryDTO;
import ro.msg.learning.shop.dto.ProductOrderDTO;
import ro.msg.learning.shop.exception.CustomerNotFoundException;
import ro.msg.learning.shop.exception.LocationNotFound;
import ro.msg.learning.shop.exception.OrderCannotBeCompleted;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.repository.*;
import ro.msg.learning.shop.strategy.ILocationStrategy;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderService{
    private final IProductOrderRepository orderRepository;
    private final StockService stockService;
    private final CustomerService customerService;
    private final OrderDetailService orderDetailService;
    private final ProductService productService;
    private final ILocationStrategy locationStrategy;
    private final ModelMapper modelMapper;

    public ProductOrder mapToEntity(OrderDTO orderDTO){
        ProductOrder order = modelMapper.map(orderDTO,ProductOrder.class);
        order.setProducts(orderDTO.getProducts());
        return order;
    }

    public OrderDTO mapToDTO(ProductOrder order){
        OrderDTO orderDTO = modelMapper.map(order,OrderDTO.class);
        return orderDTO;
    }

    public List<ProductOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public ProductOrder createOrder(Integer customerID, ProductOrder order) {
        order.setCreated_at(LocalDateTime.now());

        List<Stock> stocks = findLocationStrategy(order);

        Random rand = new Random();
        Stock stock = stocks.get(rand.nextInt(stocks.size()));

        Customer customer = customerService.findById(customerID);
        Long orderSizeInitial = orderRepository.count();

        List<ProductOrderDTO> products = productsList(order);

        order.setShipped_from(stock.getLocation());
        order.setCustomer(customer);
        orderRepository.save(order);

        Long orderSizeFinal = orderRepository.count();

        if (orderSizeInitial.equals(orderSizeFinal))
            throw new OrderCannotBeCompleted();

        for(ProductOrderDTO orderedProduct: products) {
            if (orderedProduct.getProductId().equals(stock.getProduct().getId())) {
                stock.setQuantity(stock.getQuantity() - orderedProduct.getQuantity());
                stockService.saveStock(stock);

                OrderDetail orderDetail = new OrderDetail(orderedProduct.getQuantity(), stock.getProduct(), order);
                orderDetailService.createOrderDetail(orderDetail);
                break;
            }
        }
        return order;
    }

    private List<ProductOrderDTO> productsList(ProductOrder order) {
        List<ProductOrderDTO> orderedProducts = new ArrayList<>();

        order.getProducts().forEach((productId, quantity) -> {
            Product product = productService.findById(productId);
            ProductOrderDTO orderedProduct = ProductOrderDTO.builder()
                    .productId(product.getId())
                    .quantity(quantity)
                    .build();
            orderedProducts.add(orderedProduct);
        });
        return orderedProducts;
    }

    private List<Stock> findLocationStrategy(ProductOrder order) {
        List<ProductOrderDTO> products = productsList(order);
        List<Stock> stocks = locationStrategy.findBestLocations(products);

        if (stocks == null || stocks.isEmpty())
            throw new LocationNotFound();

        return stocks;
    }
}
