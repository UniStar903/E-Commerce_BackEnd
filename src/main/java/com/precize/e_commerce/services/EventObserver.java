package com.precize.e_commerce.services;

import com.precize.e_commerce.events.Event;
import com.precize.e_commerce.model.Order;

public interface EventObserver {
    void onEventProcessed(Event event, Order order);
}
