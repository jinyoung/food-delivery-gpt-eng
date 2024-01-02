package com.example.ridermanagement.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, String> {
    // Custom query methods can be added here if needed
}