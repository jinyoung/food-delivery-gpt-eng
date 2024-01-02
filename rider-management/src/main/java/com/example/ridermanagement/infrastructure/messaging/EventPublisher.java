package com.example.ridermanagement.infrastructure.messaging;

import com.example.ridermanagement.domain.event.DeliveryCompletedEvent;
import com.example.ridermanagement.domain.event.OrderAssignedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {
    private final Source source;

    @Autowired
    public EventPublisher(Source source) {
        this.source = source;
    }

    public void publishOrderAssignedEvent(OrderAssignedEvent event) {
        source.output().send(MessageBuilder.withPayload(event).build());
    }

    public void publishDeliveryCompletedEvent(DeliveryCompletedEvent event) {
        source.output().send(MessageBuilder.withPayload(event).build());
    }
}