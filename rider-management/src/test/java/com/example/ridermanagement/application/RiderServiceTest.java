package com.example.ridermanagement.application;

import com.example.ridermanagement.domain.RiderRepository;
import com.example.ridermanagement.domain.command.AcceptOrderCommand;
import com.example.ridermanagement.domain.command.MarkDeliveryCompletedCommand;
import com.example.ridermanagement.domain.event.OrderAssignedEvent;
import com.example.ridermanagement.domain.event.DeliveryCompletedEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RiderServiceTest {
    @Mock
    private RiderRepository riderRepository;

    @InjectMocks
    private RiderService riderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void acceptOrder_ShouldReturnOrderAssignedEvent() {
        AcceptOrderCommand command = new AcceptOrderCommand("order-123");
        OrderAssignedEvent event = riderService.acceptOrder(command);

        assertNotNull(event);
        assertEquals("order-123", event.getOrderId());
        // Additional assertions can be added here
    }

    @Test
    void markDeliveryCompleted_ShouldReturnDeliveryCompletedEvent() {
        MarkDeliveryCompletedCommand command = new MarkDeliveryCompletedCommand("order-123");
        DeliveryCompletedEvent event = riderService.markDeliveryCompleted(command);

        assertNotNull(event);
        assertEquals("order-123", event.getOrderId());
        // Additional assertions can be added here
    }
}