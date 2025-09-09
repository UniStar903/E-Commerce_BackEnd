package com.precize.e_commerce.services;

import com.precize.e_commerce.config.EventNotifier;
import com.precize.e_commerce.model.Order;
import com.precize.e_commerce.model.enums.Status;
import com.precize.e_commerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final EventNotifier eventNotifier;

    public Order updateOrderStatus(String orderId, Status newStatus) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus(newStatus);
            orderRepository.save(order);
            eventNotifier.notifyObservers(null, order);
            return order;
        } else {
            throw new RuntimeException("Order not found: " + orderId);
        }
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(@PathVariable String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }

    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    public String deleteOrder(@PathVariable String id) {
        orderRepository.deleteById(id);
        return "Order deleted: " + id;
    }

}
