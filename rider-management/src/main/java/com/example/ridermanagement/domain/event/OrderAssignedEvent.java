package com.example.ridermanagement.domain.event;

import lombok.Value;

@Value
public class OrderAssignedEvent {
    String orderId;
    String riderId;
}