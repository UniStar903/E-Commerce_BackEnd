package com.precize.e_commerce.events;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentReceivedEvent extends Event {
    private String orderId;
    private Double amountPaid;
}
