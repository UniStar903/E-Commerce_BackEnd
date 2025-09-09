package com.precize.e_commerce.config;
import com.precize.e_commerce.model.Order;
import com.precize.e_commerce.model.enums.Status;
import com.precize.e_commerce.events.Event;
import com.precize.e_commerce.services.EventObserver;
import org.springframework.stereotype.Component;

@Component
public class AlertObserver implements EventObserver {
    @Override
    public void onEventProcessed(Event event, Order order) {
        if (order.getStatus() == Status.CANCELLED || order.getStatus() == Status.SHIPPED) {
            System.out.println("Alert: " +
                    order.getOrderId() + " Status changed to " + order.getStatus());
        }
    }
}
