package za.ac.cput.dogparlor.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.Order;
import za.ac.cput.dogparlor.repository.OrderRepository;
import za.ac.cput.dogparlor.service.IOrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order read(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order update(Order order) {
        if (orderRepository.existsById(order.getOrderId()))
            return orderRepository.save(order);
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (orderRepository.existsById(id)) {
            orderRepository.existsById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
