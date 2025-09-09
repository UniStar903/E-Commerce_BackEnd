package com.precize.e_commerce.events;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCancelledEvent extends Event {
    private String orderId;
    private String reason;
}
