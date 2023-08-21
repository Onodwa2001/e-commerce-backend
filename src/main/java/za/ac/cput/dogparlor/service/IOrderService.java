package za.ac.cput.dogparlor.service;

import za.ac.cput.dogparlor.domain.Order;

import java.util.List;

public interface IOrderService extends IService<Order, String> {

    List<Order> getAllOrders();

}
