package com.precize.e_commerce.events;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShippingScheduledEvent extends Event {
    private String orderId;
    private LocalDate shippingDate;
}
