package com.precize.e_commerce.events;

import com.precize.e_commerce.model.Items;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedEvent extends Event {
    private String orderId;
    private String customerId;
    private List<Items> items;
    private Double totalAmount;
}