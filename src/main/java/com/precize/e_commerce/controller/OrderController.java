package com.precize.e_commerce.controller;
import com.precize.e_commerce.model.Order;
import com.precize.e_commerce.model.enums.Status;
import com.precize.e_commerce.repository.OrderRepository;
import com.precize.e_commerce.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @GetMapping
    public List<Order> getAll() {
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderByID(@PathVariable String id) {
        return service.getOrder(id);
    }

    @PostMapping("/create")
    public Order create(@RequestBody Order order) {
        return service.createOrder(order);
    }

    @PutMapping("/update")
    public Order updateStatus(@RequestParam String orderId,
                              @RequestParam Status status) {
        return service.updateOrderStatus(orderId, status);
    }

    @DeleteMapping("/{id}")
    public String deleteOrderByID(@PathVariable String id) {
        service.deleteOrder(id);
        return "Order deleted: " + id;
    }
}

