package org.process.basicdata.kafka;

public record OrderCreatedEvent(
        Long orderId,
        String customer,
        Double total
) {
}
