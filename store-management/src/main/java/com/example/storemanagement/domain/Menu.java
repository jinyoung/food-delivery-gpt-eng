package com.example.storemanagement.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Menu {
    @Id
    private String menuId;
    private String menuName;
    private Money price;
    private String stockStatus;
    private String availability;
}