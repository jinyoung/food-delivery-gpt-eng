package com.example.userordermanagement.commands;

import com.example.userordermanagement.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderCommand {
    private String foodSelection;
    private Integer quantity;
    private String specialRequest;
    private Address deliveryAddress;
    private String paymentMethod;
}