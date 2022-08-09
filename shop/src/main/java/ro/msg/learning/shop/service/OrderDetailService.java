package ro.msg.learning.shop.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.repository.IRepositoryOrderDetail;

@Service
@RequiredArgsConstructor
public class OrderDetailService {
    private final IRepositoryOrderDetail orderDetailRepository;

    public void createOrderDetail(OrderDetail orderDetail){
        orderDetailRepository.save(orderDetail);
    }
}
