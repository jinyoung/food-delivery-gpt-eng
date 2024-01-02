package com.example.ridermanagement.domain.command;

import lombok.Value;

@Value
public class AcceptOrderCommand {
    String orderId;
}