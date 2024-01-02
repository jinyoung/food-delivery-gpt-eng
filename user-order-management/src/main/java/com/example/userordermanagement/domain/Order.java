package com.example.userordermanagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID orderId;

    private String foodSelection;
    private Integer quantity;
    private String specialRequest;

    @Embedded
    private Address deliveryAddress;

    private String paymentMethod;
    private String paymentMethodType;

    @Embedded
    private Money orderAmount;

    private String orderStatus;
    private String estimatedDeliveryTime;
}