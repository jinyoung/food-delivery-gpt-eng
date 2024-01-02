package com.example.userordermanagement.service;

import com.example.userordermanagement.commands.CancelOrderCommand;
import com.example.userordermanagement.commands.CheckPreviousOrdersCommand;
import com.example.userordermanagement.commands.ConfirmOrderCommand;
import com.example.userordermanagement.commands.PlaceOrderCommand;
import com.example.userordermanagement.domain.Order;
import com.example.userordermanagement.events.OrderCancelledEvent;
import com.example.userordermanagement.events.OrderPlacedEvent;
import com.example.userordermanagement.events.PreviousOrdersCheckedEvent;
import com.example.userordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public OrderPlacedEvent placeOrder(PlaceOrderCommand command) {
        // Logic to place an order
        Order order = new Order();
        // Set properties from command to order
        order = orderRepository.save(order);
        // Publish OrderPlacedEvent
        return new OrderPlacedEvent(order.getOrderId(), order.getFoodSelection(), order.getQuantity(),
                order.getSpecialRequest(), order.getDeliveryAddress(), order.getPaymentMethod(), order.getOrderAmount());
    }

    @Transactional
    public OrderCancelledEvent cancelOrder(CancelOrderCommand command) {
        // Logic to cancel an order
        Order order = orderRepository.findById(command.getOrderId()).orElseThrow();
        orderRepository.delete(order);
        // Publish OrderCancelledEvent
        return new OrderCancelledEvent(order.getOrderId());
    }

    @Transactional(readOnly = true)
    public PreviousOrdersCheckedEvent checkPreviousOrders(CheckPreviousOrdersCommand command) {
        // Logic to check previous orders
        // Publish PreviousOrdersCheckedEvent
        return new PreviousOrdersCheckedEvent();
    }

    @Transactional
    public void confirmOrder(ConfirmOrderCommand command) {
        // Logic to confirm an order
        Order order = orderRepository.findById(command.getOrderId()).orElseThrow();
        // Update order status to confirmed
        // No event is published in this example, but in a real scenario, you might publish an event
    }
}