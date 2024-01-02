package com.example.ridermanagement.application;

import com.example.ridermanagement.domain.Rider;
import com.example.ridermanagement.domain.RiderRepository;
import com.example.ridermanagement.domain.command.AcceptOrderCommand;
import com.example.ridermanagement.domain.command.MarkDeliveryCompletedCommand;
import com.example.ridermanagement.domain.event.OrderAssignedEvent;
import com.example.ridermanagement.domain.event.DeliveryCompletedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RiderService {
    private final RiderRepository riderRepository;

    @Autowired
    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    @Transactional
    public OrderAssignedEvent acceptOrder(AcceptOrderCommand command) {
        // Business logic to accept the order
        // For now, we'll just create a dummy event
        return new OrderAssignedEvent(command.getOrderId(), "dummy-rider-id");
    }

    @Transactional
    public DeliveryCompletedEvent markDeliveryCompleted(MarkDeliveryCompletedCommand command) {
        // Business logic to mark delivery as completed
        // For now, we'll just create a dummy event
        return new DeliveryCompletedEvent(command.getOrderId());
    }
}