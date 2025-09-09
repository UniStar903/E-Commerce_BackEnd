package com.precize.e_commerce.config;
import com.precize.e_commerce.model.Order;
import com.precize.e_commerce.events.Event;
import com.precize.e_commerce.services.EventObserver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventNotifier {
    private final List<EventObserver> observers;

    public EventNotifier(List<EventObserver> observers) {
        this.observers = observers;
    }

    public void notifyObservers(Event event, Order order) {
        for (EventObserver observer : observers) {
            observer.onEventProcessed(event, order);
        }
    }
}

