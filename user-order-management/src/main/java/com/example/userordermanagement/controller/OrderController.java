package com.example.userordermanagement.controller;

import com.example.userordermanagement.commands.CancelOrderCommand;
import com.example.userordermanagement.commands.CheckPreviousOrdersCommand;
import com.example.userordermanagement.commands.ConfirmOrderCommand;
import com.example.userordermanagement.commands.PlaceOrderCommand;
import com.example.userordermanagement.events.OrderCancelledEvent;
import com.example.userordermanagement.events.OrderPlacedEvent;
import com.example.userordermanagement.events.PreviousOrdersCheckedEvent;
import com.example.userordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderPlacedEvent> placeOrder(@RequestBody PlaceOrderCommand command) {
        OrderPlacedEvent event = orderService.placeOrder(command);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<OrderCancelledEvent> cancelOrder(@PathVariable UUID orderId) {
        CancelOrderCommand command = new CancelOrderCommand(orderId);
        OrderCancelledEvent event = orderService.cancelOrder(command);
        return ResponseEntity.ok(event);
    }

    @GetMapping("/previous")
    public ResponseEntity<PreviousOrdersCheckedEvent> checkPreviousOrders() {
        CheckPreviousOrdersCommand command = new CheckPreviousOrdersCommand();
        PreviousOrdersCheckedEvent event = orderService.checkPreviousOrders(command);
        return ResponseEntity.ok(event);
    }

    @PostMapping("/{orderId}/confirm")
    public ResponseEntity<Void> confirmOrder(@PathVariable UUID orderId) {
        ConfirmOrderCommand command = new ConfirmOrderCommand(orderId);
        orderService.confirmOrder(command);
        return ResponseEntity.ok().build();
    }
}