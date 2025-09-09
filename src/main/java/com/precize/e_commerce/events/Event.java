package com.precize.e_commerce.events;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "eventType",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = OrderCreatedEvent.class, name = "OrderCreated"),
        @JsonSubTypes.Type(value = PaymentReceivedEvent.class, name = "PaymentReceived"),
        @JsonSubTypes.Type(value = ShippingScheduledEvent.class, name = "ShippingScheduled"),
        @JsonSubTypes.Type(value = OrderCancelledEvent.class, name = "OrderCancelled")
})
public abstract class Event {

    @Id
    private String eventId = UUID.randomUUID().toString();
    private Instant timestamp = Instant.now();
    private String eventType;
}
