package com.example.ridermanagement.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "riders")
@Getter
@Setter
@NoArgsConstructor
public class Rider {
    @Id
    private String riderId;
    private String riderName;
    private String riderStatus;

    // Business logic methods will be added here
}