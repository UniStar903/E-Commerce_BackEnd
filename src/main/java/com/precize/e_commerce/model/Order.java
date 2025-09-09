package com.precize.e_commerce.model;

import com.precize.e_commerce.model.enums.Status;
import com.precize.e_commerce.events.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "order")
public class Order {
    @Id
    private String orderId;
    private String customerId;
    @Builder.Default
    private List<Items> items = new ArrayList<>();
    private double totalAmount;
    @Builder.Default
    private Status status = Status.DEFAULT;
    @Builder.Default
    private List<Event> eventHistory = new ArrayList<>();
}
