package com.example.ridermanagement.domain.event;

import lombok.Value;

@Value
public class DeliveryCompletedEvent {
    String orderId;
}