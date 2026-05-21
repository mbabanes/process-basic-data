package org.process.basicdata.kafka;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer producer;

    public OrderController(OrderProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String createOrder() {

        OrderCreatedEvent event =
                new OrderCreatedEvent(
                        1L,
                        "Jan Kowalski",
                        199.99
                );

        producer.send(event);

        return "sent";
    }
}
