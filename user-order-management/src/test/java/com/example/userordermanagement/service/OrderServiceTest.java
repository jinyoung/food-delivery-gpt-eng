package com.example.userordermanagement.service;

import com.example.userordermanagement.commands.PlaceOrderCommand;
import com.example.userordermanagement.domain.Address;
import com.example.userordermanagement.domain.Order;
import com.example.userordermanagement.events.OrderPlacedEvent;
import com.example.userordermanagement.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPlaceOrder() {
        // Given
        PlaceOrderCommand command = new PlaceOrderCommand("Pizza", 2, "Extra cheese", new Address(), "Credit Card");
        Order order = new Order();
        order.setOrderId(UUID.randomUUID());
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        // When
        OrderPlacedEvent event = orderService.placeOrder(command);

        // Then
        assertNotNull(event);
        assertNotNull(event.getOrderId());
    }
}