package com.example.ridermanagement.interfaces;

import com.example.ridermanagement.application.RiderService;
import com.example.ridermanagement.domain.command.AcceptOrderCommand;
import com.example.ridermanagement.domain.command.MarkDeliveryCompletedCommand;
import com.example.ridermanagement.domain.event.OrderAssignedEvent;
import com.example.ridermanagement.domain.event.DeliveryCompletedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/riders")
public class RiderController {
    private final RiderService riderService;

    @Autowired
    public RiderController(RiderService riderService) {
        this.riderService = riderService;
    }

    @PostMapping("/{riderId}/accept-order")
    public ResponseEntity<OrderAssignedEvent> acceptOrder(@PathVariable String riderId, @RequestBody AcceptOrderCommand command) {
        OrderAssignedEvent event = riderService.acceptOrder(command);
        return ResponseEntity.ok(event);
    }

    @PostMapping("/{riderId}/mark-delivery-completed")
    public ResponseEntity<DeliveryCompletedEvent> markDeliveryCompleted(@PathVariable String riderId, @RequestBody MarkDeliveryCompletedCommand command) {
        DeliveryCompletedEvent event = riderService.markDeliveryCompleted(command);
        return ResponseEntity.ok(event);
    }
}