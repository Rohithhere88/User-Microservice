// src/main/java/com/example/userservice/entity/Subscription.java
package com.example.userservice.entity;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "subscriptions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionId;

    @Column(nullable = false)
    private Long userId;

    private String planName; // e.g., "Premium", "Basic"

    private LocalDate startDate;
    private LocalDate endDate;

    private Boolean isActive = true;
}