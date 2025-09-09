package com.precize.e_commerce.services;
import com.precize.e_commerce.config.EventNotifier;
import com.precize.e_commerce.events.*;
import com.precize.e_commerce.model.Order;
import com.precize.e_commerce.model.enums.Status;
import com.precize.e_commerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class EventProcessor {

    private final OrderRepository orderRepository;
    private final EventNotifier eventNotifier;

    public void processEvent(Event event) {
        switch (event) {
            case OrderCreatedEvent e -> handleOrderCreated(e);
            case PaymentReceivedEvent e -> handlePaymentReceived(e);
            case ShippingScheduledEvent e -> handleShippingScheduled(e);
            case OrderCancelledEvent e -> handleOrderCancelled(e);
            case null, default -> {
                assert event != null;
                System.out.println("Event type: " + event.getEventType());
            }
        }
    }

    private void handleOrderCreated(OrderCreatedEvent event) {
        Order order = new Order();
        order.setOrderId(event.getOrderId());
        order.setCustomerId(event.getCustomerId());
        order.setItems(event.getItems());
        order.setTotalAmount(event.getTotalAmount());
        order.setStatus(Status.PENDING);
        order.setEventHistory(new ArrayList<>());
        order.getEventHistory().add(event);

        orderRepository.save(order);
        eventNotifier.notifyObservers(event, order);
    }

    private void handlePaymentReceived(PaymentReceivedEvent event) {
        orderRepository.findById(event.getOrderId()).ifPresentOrElse(order -> {
            if (event.getAmountPaid() >= order.getTotalAmount())
                order.setStatus(Status.PAID);
            else
                System.out.println("Payment received: " + order.getOrderId());
            order.getEventHistory().add(event);
            orderRepository.save(order);
            eventNotifier.notifyObservers(event, order);
        }, () -> System.out.println("Order not found: " + event.getOrderId()));
    }

    private void handleShippingScheduled(ShippingScheduledEvent event) {
        orderRepository.findById(event.getOrderId()).ifPresentOrElse(order -> {
            order.setStatus(Status.SHIPPED);
            order.getEventHistory().add(event);
            orderRepository.save(order);
            eventNotifier.notifyObservers(event, order);
        }, () -> System.out.println("Order not found: " + event.getOrderId()));
    }

    private void handleOrderCancelled(OrderCancelledEvent event) {
        orderRepository.findById(event.getOrderId()).ifPresentOrElse(order -> {
            order.setStatus(Status.CANCELLED);
            order.getEventHistory().add(event);
            orderRepository.save(order);
            eventNotifier.notifyObservers(event, order);
        }, () -> System.out.println("Order not found: " + event.getOrderId()));
    }
}

