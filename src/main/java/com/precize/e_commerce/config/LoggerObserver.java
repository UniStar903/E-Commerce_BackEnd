package com.precize.e_commerce.config;
import com.precize.e_commerce.model.Order;
import com.precize.e_commerce.events.Event;
import com.precize.e_commerce.services.EventObserver;
import org.springframework.stereotype.Component;

@Component
public class LoggerObserver implements EventObserver {
    @Override
    public void onEventProcessed(Event event, Order order) {
        System.out.println("Event: " + event.getEventType() +
                "\nprocessed Order: " + order.getOrderId() +
                 "\nStatus: " + order.getStatus());
    }
}

