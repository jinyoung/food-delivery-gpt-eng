package com.example.storemanagement.infrastructure;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {
    private final Source source;

    public EventPublisher(Source source) {
        this.source = source;
    }

    public void publish(Object event) {
        source.output().send(MessageBuilder.withPayload(event).build());
    }
}