package com.example.userordermanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    // Assuming Address fields, add them as per your requirements
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}