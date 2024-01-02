package com.example.userordermanagement.events;

import com.example.userordermanagement.domain.Address;
import com.example.userordermanagement.domain.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPlacedEvent {
    private UUID orderId;
    private String foodSelection;
    private Integer quantity;
    private String specialRequest;
    private Address deliveryAddress;
    private String paymentMethod;
    private Money orderAmount;
}