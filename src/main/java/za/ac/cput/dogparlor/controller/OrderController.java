package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.Order;
import za.ac.cput.dogparlor.service.impl.OrderServiceImpl;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/place-order")
    public Order placeOrder(@RequestBody Order order) {
        return orderService.create(order);
    }

    @DeleteMapping("/delete-order/{id}")
    public boolean cancelOrder(@PathVariable String id) {
        return orderService.delete(id);
    }

}
